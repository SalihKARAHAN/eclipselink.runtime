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
package org.eclipse.persistence.testing.models.optimisticlocking;

import java.util.*;

/**
 * TopLink generated Project class.
 * <b>WARNING</b>: This code was generated by an automated tool.
 * Any changes will be lost when the code is re-generated
 */
public class RockBandProject extends org.eclipse.persistence.sessions.Project {

    /**
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    public RockBandProject() {
        applyPROJECT();
        applyLOGIN();
        buildBassDescriptor();
        buildDrumKitDescriptor();
        buildGuitarDescriptor();
        buildMusicalInstrumentDescriptor();
        buildMusicianDescriptor();
        buildRockBandDescriptor();
        buildRockMusicianDescriptor();
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyLOGIN() {
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyPROJECT() {
        setName("RockBand");
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildBassDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.Bass.class);
        descriptor.getInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.optimisticlocking.Guitar.class);

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildDrumKitDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.DrumKit.class);
        descriptor.getInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.optimisticlocking.MusicalInstrument.class);
        Vector vector = new Vector();
        vector.addElement("DRUMKIT");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("DRUMKIT.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);

	Vector v = new Vector();
	v.addElement("MUSICALINSTRUMENT.L_FIELD");
	v.addElement("DRUMKIT.KIT_SIZE");
	descriptor.useSelectedFieldsLocking(v);
    
        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("kitSize");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("DRUMKIT.KIT_SIZE");
        descriptor.addMapping(directtofieldmapping);
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildGuitarDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.Guitar.class);
        descriptor.getInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.optimisticlocking.MusicalInstrument.class);
        Vector vector = new Vector();
        vector.addElement("GUITAR");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("GUITAR.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("isAcoustic");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("GUITAR.IS_ACOUSTIC");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("numberOfStrings");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("GUITAR.NUMBER_OF_STRINGS");
        descriptor.addMapping(directtofieldmapping1);
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildMusicalInstrumentDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.MusicalInstrument.class);
        Vector vector = new Vector();
        vector.addElement("MUSICALINSTRUMENT");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("MUSICALINSTRUMENT.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("INS_EQ");
        descriptor.setSequenceNumberFieldName("ID");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);
        descriptor.getInheritancePolicy().setClassIndicatorFieldName("SUBCLASS");
        descriptor.getInheritancePolicy().setShouldUseClassNameAsIndicator(true);
	Vector v = new Vector();
	v.addElement("MUSICALINSTRUMENT.L_FIELD");
	descriptor.useSelectedFieldsLocking(v);

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("colour");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("MUSICALINSTRUMENT.COLOUR");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("id");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("MUSICALINSTRUMENT.ID");
        descriptor.addMapping(directtofieldmapping1);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping2 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping2.setAttributeName("make");
        directtofieldmapping2.setIsReadOnly(false);
        directtofieldmapping2.setFieldName("MUSICALINSTRUMENT.MAKE");
        descriptor.addMapping(directtofieldmapping2);
        addDescriptor(descriptor);

        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping3 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping3.setAttributeName("lockField");
        directtofieldmapping3.setIsReadOnly(false);
        directtofieldmapping3.setFieldName("MUSICALINSTRUMENT.L_FIELD");
        descriptor.addMapping(directtofieldmapping3);
        addDescriptor(descriptor);

    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildMusicianDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.Musician.class);
        Vector vector = new Vector();
        vector.addElement("MUSICIAN");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("MUSICIAN.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("MUSIC_SEQ");
        descriptor.setSequenceNumberFieldName("ID");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);
        descriptor.getInheritancePolicy().setClassIndicatorFieldName("SUBCLASS");
        descriptor.getInheritancePolicy().setShouldUseClassNameAsIndicator(true);
	descriptor.useAllFieldsLocking();

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("id");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("MUSICIAN.ID");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("legalName");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("MUSICIAN.LEGAL_NAME");
        descriptor.addMapping(directtofieldmapping1);

        // SECTION: ONETOONEMAPPING
        org.eclipse.persistence.mappings.OneToOneMapping onetoonemapping = new org.eclipse.persistence.mappings.OneToOneMapping();
        onetoonemapping.setAttributeName("mainInstrument");
        onetoonemapping.setIsReadOnly(false);
        onetoonemapping.setUsesIndirection(false);
        onetoonemapping.setReferenceClass(org.eclipse.persistence.testing.models.optimisticlocking.MusicalInstrument.class);
        onetoonemapping.setIsPrivateOwned(false);
        onetoonemapping.addForeignKeyFieldName("MUSICIAN.MAIN_INSTRUMENT", "MUSICALINSTRUMENT.ID");
        descriptor.addMapping(onetoonemapping);
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildRockBandDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.RockBand.class);
        Vector vector = new Vector();
        vector.addElement("ROCKBAND");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("ROCKBAND.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("BAND_SEQ");
        descriptor.setSequenceNumberFieldName("ID");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
	descriptor.useChangedFieldsLocking();

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("id");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("ROCKBAND.ID");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping1 = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping1.setAttributeName("name");
        directtofieldmapping1.setIsReadOnly(false);
        directtofieldmapping1.setFieldName("ROCKBAND.NAME");
        descriptor.addMapping(directtofieldmapping1);

        // SECTION: ONETOMANYMAPPING
        org.eclipse.persistence.mappings.OneToManyMapping onetomanymapping = new org.eclipse.persistence.mappings.OneToManyMapping();
        onetomanymapping.setAttributeName("bandMembers");
        onetomanymapping.setIsReadOnly(false);
        onetomanymapping.setUsesIndirection(true);
        onetomanymapping.setReferenceClass(org.eclipse.persistence.testing.models.optimisticlocking.RockMusician.class);
        onetomanymapping.setIsPrivateOwned(false);
        onetomanymapping.addTargetForeignKeyFieldName("ROCKMUSICIAN.BAND", "ROCKBAND.ID");
        descriptor.addMapping(onetomanymapping);
        addDescriptor(descriptor);
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildRockMusicianDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.models.optimisticlocking.RockMusician.class);
        descriptor.getInheritancePolicy().setParentClass(org.eclipse.persistence.testing.models.optimisticlocking.Musician.class);
        Vector vector = new Vector();
        vector.addElement("ROCKMUSICIAN");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("ROCKMUSICIAN.ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);
        descriptor.getInheritancePolicy().setShouldReadSubclasses(true);

        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("stageName");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("ROCKMUSICIAN.STAGE_NAME");
        descriptor.addMapping(directtofieldmapping);

        // SECTION: ONETOONEMAPPING
        org.eclipse.persistence.mappings.OneToOneMapping onetoonemapping = new org.eclipse.persistence.mappings.OneToOneMapping();
        onetoonemapping.setAttributeName("band");
        onetoonemapping.setIsReadOnly(false);
        onetoonemapping.setUsesIndirection(true);
        onetoonemapping.setReferenceClass(org.eclipse.persistence.testing.models.optimisticlocking.RockBand.class);
        onetoonemapping.setIsPrivateOwned(false);
        onetoonemapping.addForeignKeyFieldName("ROCKMUSICIAN.BAND_ID", "ROCKBAND.ID");
        descriptor.addMapping(onetoonemapping);
        addDescriptor(descriptor);
    }
}
