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
package org.eclipse.persistence.testing.models.jpa.xml.merge.advanced;

import java.util.*;
import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.*;
import static javax.persistence.InheritanceType.*;
import static javax.persistence.DiscriminatorType.*;

/**
 * Bean class: ProjectBean
 * Remote interface: Project
 * Primary key class: ProjectPK
 * Home interface: ProjectHome
 *
 * >Employees have a many-to-many relationship with Projects through the
 *  projects attribute.
 * >Projects refer to Employees through the employees attribute.
 */
@Entity(name="AnnMergeProject")
@Table(name="CMP3_ANN_MERGE_PROJECT")
@Inheritance(strategy=JOINED)
@DiscriminatorColumn(name="ANN_MERGE_PROJ_TYPE", discriminatorType=INTEGER)
@DiscriminatorValue("0")
@NamedQuery(
	name="ann_merge_findProjectByName",
	query="SELECT OBJECT(project) FROM Project project WHERE project.name = :name"
)
public class Project implements Serializable {
    public int pre_update_count = 0;
    public int post_update_count = 0;
    public int pre_remove_count = 0;
    public int post_remove_count = 0;
    public int pre_persist_count = 0;
    public int post_persist_count = 0;
    public int post_load_count = 0;
    
	private Integer id;
	private int version;
	private String name;
	private String description;
	private Employee teamLeader;
	private Collection<Employee> teamMembers;

	public Project () {
        this.teamMembers = new Vector<Employee>();
	}

	@Id
    @GeneratedValue(strategy=SEQUENCE, generator="ANN_MERGE_PROJECT_SEQUENCE_GENERATOR")
	@SequenceGenerator(name="ANN_MERGE_PROJECT_SEQUENCE_GENERATOR", sequenceName="ANN_MERGE_PROJECT_SEQ", allocationSize=10)
	@Column(name="ANN_MERGE_PROJ_ID")
	public Integer getId() { 
        return id; 
    }
    
	public void setId(Integer id) { 
        this.id = id; 
    }

	@Version
	@Column(name="ANN_MERGE_VERSION")
	public int getVersion() { 
        return version; 
    }
    
	protected void setVersion(int version) { 
        this.version = version; 
    }

	@Column(name="ANN_MERGE_PROJ_NAME")
	public String getName() { 
        return name; 
    }
    
	public void setName(String name) { 
        this.name = name; 
    }

	@Column(name="ANN_MERGE_DESCRIP")
	public String getDescription() { 
        return description; 
    }
    
	public void setDescription(String description) { 
        this.description = description; 
    }

	@OneToOne
	@JoinColumn(name="ANN_MERGE_LEADER_ID")
	public Employee getTeamLeader() {
        return teamLeader; 
    }
    
	public void setTeamLeader(Employee teamLeader) { 
        this.teamLeader = teamLeader; 
    }

	@ManyToMany(mappedBy="projects")
	public Collection<Employee> getTeamMembers() { 
        return teamMembers; 
    }
    
	public void setTeamMembers(Collection<Employee> employees) {
		this.teamMembers = employees;
	}

    public void addTeamMember(Employee employee) {
        getTeamMembers().add(employee);
    }

    public void removeTeamMember(Employee employee) {
        getTeamMembers().remove(employee);
    }

    public String displayString() {
        StringBuffer sbuff = new StringBuffer();
        sbuff.append("Project ").append(getId()).append(": ").append(getName()).append(", ").append(getDescription());

        return sbuff.toString();
    }
    
    @PrePersist
	public void prePersist() {
        ++pre_persist_count;
	}

	@PostPersist
	public void postPersist() {
        ++post_persist_count;
	}

	@PreRemove
	public void preRemove() {
        ++pre_remove_count;
	}

	@PostRemove
	public void postRemove() {
        ++post_remove_count;
	}

	@PreUpdate
	public void preUpdate() {
        ++pre_update_count;
	}

	@PostUpdate
	public void postUpdate() {
        ++post_update_count;
	}

	@PostLoad
	public void postLoad() {
        ++post_load_count;
	}
}
