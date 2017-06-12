/**********************************************************************************
 * $URL: https://source.etudes.org/svn/apps/ambrosia/trunk/ambrosia-impl/impl/src/java/org/etudes/ambrosia/impl/UiGrid.java $
 * $Id: UiGrid.java 3632 2012-12-02 21:19:56Z ggolden $
 ***********************************************************************************
 *
 * Copyright (c) 2008 Etudes, Inc.
 * 
 * Portions completed before September 1, 2008
 * Copyright (c) 2007, 2008 The Regents of the University of Michigan & Foothill College, ETUDES Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.etudes.ambrosia.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.etudes.ambrosia.api.Grid;
import org.etudes.ambrosia.api.GridRow;

/**
 * UiGrid implements Grid
 */
public class UiGrid implements Grid
{
	protected List<GridRow> rows = new ArrayList<GridRow>();

	protected int width = 0;

	/**
	 * {@inheritDoc}
	 */
	public List<GridRow> getRows()
	{
		return this.rows;
	}

	/**
	 * {@inheritDoc}
	 */
	public void load(Collection<? extends Object> objects)
	{
		if (this.width == 0) return;

		int i = 0;
		UiGridRow row = new UiGridRow();
		this.rows.add(row);
		for (Object o : objects)
		{
			if (i >= this.width)
			{
				i = 0;
				row = new UiGridRow();
				this.rows.add(row);
			}

			// add o to row at i
			row.add(o);
			i++;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
}
