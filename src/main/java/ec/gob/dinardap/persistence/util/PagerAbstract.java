package ec.gob.dinardap.persistence.util;

import java.io.Serializable;
import java.util.List;

public abstract class PagerAbstract<T> implements Serializable {

	private static final long serialVersionUID = -308504042034796174L;

	/* paginacion */
	private List<T> list;

	private int initIndex = 0;

	private int rowPerPage = 1; // filas por pagina

	private Long totalIndex; // total registros

	public PagerAbstract(int rowPerPage) {
		if (initialized == false) {
			this.rowPerPage = rowPerPage;
			setInitIndex(0);
			initialized = true;
		}
	}

	public int getActualPage() {
		int resp = 1;
		if (this.initIndex != 0) {
			resp = (this.initIndex / this.rowPerPage) + 1;
		}

		return resp;
	}

	public int getTotalPages() {
		Long resp = getTotalIndex() / this.rowPerPage;

		return resp.intValue() + 1;
	}

	public void search() {
		setInitIndex(0);// vuelve a la primera pagina
		loadPage();
		totalIndex = getTotal();
	}

	protected abstract Long getTotal();

	private boolean nextOn = true;
	private boolean backOn = true;
	private boolean lastOn = true;
	private boolean firstOn = true;
	private boolean panelButtonsOn = true;
	private boolean initialized = false;

	public String firstPage() {

		setInitIndex(0);
		loadPage();

		return null;
	}

	public String previousPage() {

		initIndex -= rowPerPage;
		loadPage();
		return null;
	}

	public String nextPage() {
		initIndex += rowPerPage;
		loadPage();
		return null;
	}

	public String lastPage() {

		initIndex = (int) (getTotalIndex() - (getTotalIndex() % rowPerPage));
		loadPage();
		return null;
	}

	/**
	 * @return the initIndex
	 */
	public int getInitIndex() {
		return initIndex;
	}

	/**
	 * @param initIndex
	 *            the initIndex to set
	 */
	public void setInitIndex(int initIndex) {
		this.initIndex = initIndex;
	}

	/**
	 * @return the rowPerPage
	 */
	public int getRowPerPage() {
		return rowPerPage;
	}

	/**
	 * @param rowPerPage
	 *            the rowPerPage to set
	 */
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	/**
	 * @return the totalIndex
	 */
	public Long getTotalIndex() {
		if (totalIndex == null) {
			totalIndex = getTotal();
		}
		return totalIndex;
	}

	/**
	 * @param totalIndex
	 *            the totalIndex to set
	 */
	public void setTotalIndex(Long totalIndex) {
		this.totalIndex = totalIndex;
	}

	public boolean isNextOn() {
		if (initIndex >= (getTotalIndex() - rowPerPage)) {
			nextOn = true;
		} else {
			nextOn = false;
		}
		return nextOn;
	}

	public void setNextOn(boolean nextOn) {
		this.nextOn = nextOn;
	}

	public boolean isBackOn() {
		if (initIndex >= 1) {
			backOn = true;
		} else {
			backOn = false;
		}
		return backOn;
	}

	public void setBackOn(boolean backOn) {
		this.backOn = backOn;
	}

	public boolean isLastOn() {
		if (initIndex >= (getTotalIndex() - rowPerPage)) {
			lastOn = true;
		} else {
			lastOn = false;
		}
		return lastOn;
	}

	public void setLastOn(boolean lastOn) {
		this.lastOn = lastOn;
	}

	public boolean isFirstOn() {
		if (initIndex >= 1) {
			firstOn = true;
		} else {
			firstOn = false;
		}
		return firstOn;
	}

	public void setFirstOn(boolean firstOn) {
		this.firstOn = firstOn;
	}

	/**
	 * @return the panelButtonsOn
	 */
	public boolean isPanelButtonsOn() {
		if (getTotalIndex() > 0) {
			panelButtonsOn = true;
		} else {
			panelButtonsOn = false;
		}
		return panelButtonsOn;
	}

	/**
	 * @param panelButtonsOn
	 *            the panelButtonsOn to set
	 */
	public void setPanelButtonsOn(boolean panelButtonsOn) {
		this.panelButtonsOn = panelButtonsOn;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		if (list == null) {
			loadPage();
		}
		return list;
	}

	protected abstract void loadPage();

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
}