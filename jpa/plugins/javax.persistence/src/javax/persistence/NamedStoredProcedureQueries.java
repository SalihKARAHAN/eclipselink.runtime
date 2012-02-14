/*******************************************************************************
 * Copyright (c) 2008 - 2012 Oracle Corporation. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Linda DeMichiel - Java Persistence 2.1
 *     Linda DeMichiel - Java Persistence 2.0
 *
 ******************************************************************************/ 
package javax.persistence; 

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies multiple named stored procedure queries.  Query names
 * are scoped to the persistence unit.  The <code>NamedStoredProcedureQueries</code> 
 * annotation can be applied to an entity or mapped superclass.
 *
 * @see NamedStoredProcedureQuery
 *
 * @since Java Persistence 2.1
 */
@Target({TYPE}) 
@Retention(RUNTIME)
public @interface NamedStoredProcedureQueries { 

    /** (Required) Array of <code>NamedStoredProcedureQuery</code> annotations. */
    NamedStoredProcedureQuery[] value ();
}