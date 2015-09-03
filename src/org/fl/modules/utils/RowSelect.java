/*
 * Copyright 2004 original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fl.modules.utils;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * Used to figure out the row information so the proper page of information can
 * be retrieved.
 * </p>
 * 
 * @since 2.0
 * @author Jeff Johnston
 */
public class RowSelect implements Serializable {
	
	/** The max rows. */
	private int maxRows;
	
	/** The page. */
	private int page;
	
	/** The row end. */
	private int rowEnd;
	
	/** The row start. */
	private int rowStart;
	
	/** The total rows. */
	private int totalRows;
	
	/**
	 * Instantiates a new row select.
	 * 
	 * @param page
	 *            the page
	 * @param maxRows
	 *            the max rows
	 * @param totalRows
	 *            the total rows
	 */
	public RowSelect(int page, int maxRows, int totalRows) {
		this.maxRows = maxRows;
		this.totalRows = totalRows;
		init(page);
	}
	
	/**
	 * Gets the max rows.
	 * 
	 * @return The maximum possible rows that could be displayed on one page.
	 */
	public int getMaxRows() {
		return maxRows;
	}
	
	/**
	 * Gets the page.
	 * 
	 * @return The current page that is being displayed.
	 */
	public int getPage() {
		return page;
	}
	
	/**
	 * Gets the row end.
	 * 
	 * @return The last row to display.
	 */
	public int getRowEnd() {
		return rowEnd;
	}
	
	/**
	 * Gets the row start.
	 * 
	 * @return The first row to display.
	 */
	public int getRowStart() {
		return rowStart;
	}
	
	/**
	 * Gets the total rows.
	 * 
	 * @return The total possible rows, including those that are paginated.
	 */
	public int getTotalRows() {
		return totalRows;
	}
	
	/**
	 * Set the max rows and recalculate the row information.
	 * 
	 * @param maxRows
	 *            The maxRows that should be displayed.
	 */
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
		init(page);
	}
	
	/**
	 * Set the page and recalculate the row information.
	 * 
	 * @param page
	 *            The page that should be displayed.
	 */
	public void setPage(int page) {
		init(page);
	}
	
	/**
	 * Set the total rows and recalculate the row information.
	 * 
	 * @param totalRows
	 *            The totalRows that should be displayed.
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		init(page);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("page", page);
		builder.append("maxRows", maxRows);
		builder.append("rowEnd", rowEnd);
		builder.append("rowStart", rowStart);
		builder.append("totalRows", totalRows);
		return builder.toString();
	}
	
	/**
	 * The page returned that is not greater than the pages that can display.
	 * 
	 * @param page
	 *            the page
	 * @param maxRows
	 *            the max rows
	 * @param totalRows
	 *            the total rows
	 * @return the valid page
	 */
	private int getValidPage(int page, int maxRows, int totalRows) {
		while (!isValidPage(page, maxRows, totalRows)) {
			--page;
		}
		return page;
	}
	
	/**
	 * Inits the.
	 * 
	 * @param page
	 *            the page
	 */
	private void init(int page) {
		page = getValidPage(page, maxRows, totalRows);
		
		int rs = (page - 1) * maxRows;
		
		int re = rs + maxRows;
		
		if (re > totalRows) {
			re = totalRows;
		}
		
		this.page = page;
		this.rowStart = rs;
		this.rowEnd = re;
	}
	
	/**
	 * Testing that the page returned is not greater than the pages that are
	 * able to be displayed. The problem arises if using the state feature and
	 * rows are deleted.
	 * 
	 * @param page
	 *            the page
	 * @param maxRows
	 *            the max rows
	 * @param totalRows
	 *            the total rows
	 * @return true, if is valid page
	 */
	private boolean isValidPage(int page, int maxRows, int totalRows) {
		if (page == 1) {
			return true;
		}
		
		int rs = (page - 1) * maxRows;
		int re = rs + maxRows;
		if (re > totalRows) {
			re = totalRows;
		}
		return re > rs;
	}
}
