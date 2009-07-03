/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.inheritance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.persistence.testing.jaxb.JAXBTestCases;
import org.eclipse.persistence.testing.jaxb.JAXBXMLComparer;
import org.eclipse.persistence.testing.jaxb.events.Address;
import org.eclipse.persistence.testing.jaxb.events.Employee;
import org.eclipse.persistence.testing.jaxb.events.PhoneNumber;
import org.w3c.dom.Document;

public class JAXBInheritanceTestCases extends JAXBTestCases {
	public JAXBInheritanceTestCases(String name) throws Exception {
		super(name);
		setClasses(new Class[] { A.class, B.class, C.class, D.class, E.class });
		setControlDocument("org/eclipse/persistence/testing/jaxb/inheritance/inheritance.xml");
	}

	public Object getControlObject() {
		// reads a document that also contains a value for "ddd" and makes sure
		// we ignore it
		E object = new E();
		object.setAaa(1);
		object.setBbb(2);
		object.setCcc(3);
		object.setDdd(4);
		object.setEee(5);
		QName qname = new QName("", "a-element");
		JAXBElement jaxbElement = new JAXBElement(qname, A.class, object);

		return jaxbElement;
	}

	public void testSchemaGen() throws Exception {
		List<File> generatedFiles = generateSchema();
		assertNotNull(generatedFiles);
		assertEquals(1, generatedFiles.size());
		
		String controlSchemaFileName = "org/eclipse/persistence/testing/jaxb/inheritance/schema0.xsd";

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setIgnoringElementContentWhitespace(true);
		builderFactory.setNamespaceAware(true);
		
		InputStream stream = ClassLoader.getSystemResourceAsStream(controlSchemaFileName);
		Document control = parser.parse(stream);

		stream = new FileInputStream(generatedFiles.get(0));
		Document test = parser.parse(stream);

		JAXBXMLComparer xmlComparer = new JAXBXMLComparer();

		assertTrue("schema0.xsd did not match control document", xmlComparer.isSchemaEqual(control, test));

	}
}
