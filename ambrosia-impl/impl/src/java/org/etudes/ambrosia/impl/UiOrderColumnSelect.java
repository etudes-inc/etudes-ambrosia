/**********************************************************************************
 * $URL: https://source.etudes.org/svn/apps/ambrosia/trunk/ambrosia-impl/impl/src/java/org/etudes/ambrosia/impl/UiOrderColumnSelect.java $
 * $Id: UiOrderColumnSelect.java 3632 2012-12-02 21:19:56Z ggolden $
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

import org.etudes.ambrosia.api.Context;
import org.etudes.ambrosia.api.OrderColumn;
import org.etudes.ambrosia.api.PropertyReference;
import org.etudes.ambrosia.api.SelectionColumn;
import org.sakaiproject.util.StringUtil;
import org.sakaiproject.util.Validator;
import org.w3c.dom.Element;

/**
 * UiOrderColumn implements OrderColumn using a drop-down select with positions.
 */
public class UiOrderColumnSelect extends UiEntityListColumn implements OrderColumn
{
	/** The PropertyReference for decoding this column - this is what will be updated with the selected value(s). */
	protected PropertyReference propertyReference = null;

	/** The PropertyReference for encoding this column - this is how the entity will be identified. */
	protected PropertyReference valuePropertyReference = null;

	/**
	 * Public no-arg constructor.
	 */
	public UiOrderColumnSelect()
	{
	}

	/**
	 * Construct from a dom element.
	 * 
	 * @param service
	 *        the UiService.
	 * @param xml
	 *        The dom element.
	 */
	protected UiOrderColumnSelect(UiServiceImpl service, Element xml)
	{
		// entity list column stuff
		super(service, xml);

		// short for model
		String model = StringUtil.trimToNull(xml.getAttribute("model"));
		if (model != null)
		{
			PropertyReference pRef = service.newPropertyReference().setReference(model);
			setProperty(pRef);
		}

		// model
		Element settingsXml = XmlHelper.getChildElementNamed(xml, "model");
		if (settingsXml != null)
		{
			PropertyReference pRef = service.parsePropertyReference(settingsXml);
			if (pRef != null) setProperty(pRef);
		}

		// value
		settingsXml = XmlHelper.getChildElementNamed(xml, "value");
		if (settingsXml != null)
		{
			Element innerXml = XmlHelper.getChildElementNamed(settingsXml, "model");
			if (innerXml != null)
			{
				PropertyReference pRef = service.parsePropertyReference(innerXml);
				if (pRef != null) setValueProperty(pRef);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDisplayText(Context context, Object entity, int row, String id, int size)
	{
		// read only?
		boolean readOnly = false;

		// read the entity id for this entity / column
		String value = null;
		if (this.valuePropertyReference != null)
		{
			value = this.valuePropertyReference.read(context, entity);
		}

		// if there's no identity reference, use the row number
		else
		{
			value = Integer.toString(row);
		}

		StringBuilder rv = new StringBuilder();

		rv.append("<input type=\"hidden\" name=\"" + id + "\" value=\"" + value + "\" />");

		String onchange = "onchange=\"ambrosiaTableReorderPosition(this, this.value, '" + id + "_');\" ";

		rv.append("<select " + onchange + " size=\"1\" id=\"" + id + "_" + (row + 1) + "\"" + (readOnly ? " disabled=\"disabled\"" : "") + ">\n");

		for (int i = 1; i <= size; i++)
		{
			boolean selected = (row + 1 == i);

			// the option
			rv.append("<option value=\"" + i + "\" " + (selected ? "selected=\"selected\"" : "") + ">" + i + "</option>\n");
		}

		rv.append("</select>\n");

		return rv.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOneTimeText(Context context, Object focus, String id, int numRows)
	{
		// generate some ids
		String decodeId = "decode_" + id;

		StringBuffer rv = new StringBuffer();

		// we need one hidden field to direct the decoding of all the columns
		rv.append("<input type=\"hidden\" name=\"" + decodeId + "\" value =\"" + id + "\" />" + "<input type=\"hidden\" name=\"" + "prop_" + decodeId
				+ "\" value=\"" + this.propertyReference.getFullReference(context) + "\" />");

		return rv.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public OrderColumn setProperty(PropertyReference propertyReference)
	{
		this.propertyReference = propertyReference;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public OrderColumn setValueProperty(PropertyReference propertyReference)
	{
		this.valuePropertyReference = propertyReference;
		return this;
	}
}
