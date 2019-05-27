package com.fds.repository.dataprovider.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.openarchives.oai.x20.HeaderType;
import org.openarchives.oai.x20.ListRecordsType;
import org.openarchives.oai.x20.ListSetsType;
import org.openarchives.oai.x20.MetadataType;
import org.openarchives.oai.x20.OAIPMHDocument;
import org.openarchives.oai.x20.OAIPMHtype;
import org.openarchives.oai.x20.RecordType;
import org.openarchives.oai.x20.RequestType;
import org.openarchives.oai.x20.SetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.openaire.cerifProfile.x11.CfDateType;
import eu.openaire.cerifProfile.x11.CfGenericIdentifierType;
import eu.openaire.cerifProfile.x11.CfMLangStringType;
import eu.openaire.cerifProfile.x11.CfStringType;
import eu.openaire.cerifProfile.x11.OrgUnitDocument;
import eu.openaire.cerifProfile.x11.StandardDocument;
import eu.openaire.cerifProfile.x11.CfTransType.Enum;
import eu.openaire.cerifProfile.x11.OrgUnitDocument.OrgUnit;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard;

import com.fds.repository.dataprovider.model.TCCN;
import com.fds.repository.dataprovider.model.TCCNRepository;

@RestController
@RequestMapping("/oai")
public class OAIPMHController {
    public static final Logger logger = LoggerFactory.getLogger(OAIPMHController.class);

    @Autowired
    private TCCNRepository tccnRepository;

    @RequestMapping(value = "/test/", method = RequestMethod.GET, produces = { "application/xml" })
    public String getTest() {
		Calendar c = Calendar.getInstance();
		
		OAIPMHDocument doc = OAIPMHDocument.Factory.newInstance();
		OAIPMHtype type = doc.addNewOAIPMH();
		c.setTime(new Date());
		type.setResponseDate(c);
		ListRecordsType lrType = type.addNewListRecords();
		RequestType request = type.addNewRequest();
		request.setMetadataPrefix("cerif_openaire");
		request.setVerb(org.openarchives.oai.x20.VerbType.Enum.forString("ListRecords"));
		request.setSet("openaire_cris_orgunits");
		request.setStringValue("http://cris.example.org/openaire/connector");
		type.setListRecords(lrType);
		RecordType rtype = lrType.addNewRecord();
		HeaderType headerType = rtype.addNewHeader();
		headerType.setIdentifier("oai:cris.example.org:OrgUnits/312345");
		headerType.setDatestamp(c);
		headerType.addSetSpec("openaire_cris_orgunits");
		
		MetadataType mtype = rtype.addNewMetadata();
		OrgUnitDocument orgDoc = OrgUnitDocument.Factory.newInstance();
		OrgUnit orgUnit = orgDoc.addNewOrgUnit();
		CfStringType acronymOrg = CfStringType.Factory.newInstance();
		acronymOrg.setStringValue("NKUA");
		orgUnit.setAcronym(acronymOrg);
		CfMLangStringType orgName = orgUnit.addNewName();
		orgName.setLang("en");
		orgName.setStringValue("NATIONAL AND KAPODISTRIAN UNIVERSITY OF ATHENS");
		CfGenericIdentifierType idenOrg = orgUnit.addNewIdentifier();
		idenOrg.setStringValue("http://www.uoa.gr");
		mtype.set(orgDoc);
        rtype.setMetadata(mtype); 
        System.out.println("XML: " + doc.toString());       
        return doc.xmlText();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/xml" })
    public String processOAIRequest(@QueryParam("verb") String verb,
        @QueryParam("identifier") String identifier,
        @QueryParam("from") String from,
        @QueryParam("to") String to) {
        if ("ListMetadataFormats".contentEquals(verb)) {
            Calendar c = Calendar.getInstance();
		
            OAIPMHDocument doc = OAIPMHDocument.Factory.newInstance();
            OAIPMHtype type = doc.addNewOAIPMH();
            c.setTime(new Date());
            type.setResponseDate(c);
            ListRecordsType lrType = type.addNewListRecords();
            RequestType request = type.addNewRequest();
            request.setMetadataPrefix("cerif_openaire");
            request.setVerb(org.openarchives.oai.x20.VerbType.Enum.forString("ListRecords"));
            request.setSet("openaire_cris_orgunits");
            request.setStringValue("http://cris.example.org/openaire/connector");
            type.setListRecords(lrType);
            RecordType rtype = lrType.addNewRecord();
            HeaderType headerType = rtype.addNewHeader();
            headerType.setIdentifier("oai:cris.example.org:OrgUnits/312345");
            headerType.setDatestamp(c);
            headerType.addSetSpec("openaire_cris_orgunits");
            
            MetadataType mtype = rtype.addNewMetadata();
            OrgUnitDocument orgDoc = OrgUnitDocument.Factory.newInstance();
            OrgUnit orgUnit = orgDoc.addNewOrgUnit();
            CfStringType acronymOrg = CfStringType.Factory.newInstance();
            acronymOrg.setStringValue("NKUA");
            orgUnit.setAcronym(acronymOrg);
            CfMLangStringType orgName = orgUnit.addNewName();
            orgName.setLang("en");
            orgName.setStringValue("NATIONAL AND KAPODISTRIAN UNIVERSITY OF ATHENS");
            CfGenericIdentifierType idenOrg = orgUnit.addNewIdentifier();
            idenOrg.setStringValue("http://www.uoa.gr");
            mtype.set(orgDoc);
            rtype.setMetadata(mtype); 
            return doc.xmlText();
        }
        else if ("ListSets".contentEquals(verb)) {
            Calendar c = Calendar.getInstance();
		
            OAIPMHDocument doc = OAIPMHDocument.Factory.newInstance();
            OAIPMHtype type = doc.addNewOAIPMH();
            c.setTime(new Date());
            type.setResponseDate(c);
            RequestType request = type.addNewRequest();
            request.setStringValue("http://an.oa.org/OAI-script");
            request.setVerb(org.openarchives.oai.x20.VerbType.Enum.forString("ListSets"));
            ListSetsType listSetType = type.addNewListSets();
            SetType setType = listSetType.addNewSet();
            setType.setSetName("Music collection");
            setType.setSetSpec("music");
            return doc.xmlText();
        }
        else if ("ListRecords".contentEquals(verb)) {
            Calendar c = Calendar.getInstance();
		
            OAIPMHDocument doc = OAIPMHDocument.Factory.newInstance();

            OAIPMHtype type = doc.addNewOAIPMH();
            c.setTime(new Date());
            type.setResponseDate(c);
            RequestType request = type.addNewRequest();
            request.setStringValue("http://an.oa.org/OAI-script");
            request.setVerb(org.openarchives.oai.x20.VerbType.Enum.forString("ListRecords"));
            
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            ListRecordsType lstRecordType = type.addNewListRecords();
            List<TCCN> lstTccns = tccnRepository.findBetweenPublicationDate(new Date(0), new Date());

            for (TCCN tccn : lstTccns) {
                RecordType recordType = lstRecordType.addNewRecord();
                MetadataType metaType = recordType.addNewMetadata();
                StandardDocument standardDoc = StandardDocument.Factory.newInstance();
                Standard standard = standardDoc.addNewStandard();

                CfDateType publicationDate = standard.addNewPublicationDate();
                publicationDate.setDateValue(tccn.getNgaycongnhan());
                CfStringType tempString = CfStringType.Factory.newInstance();
                tempString.setStringValue("TCVN");
                standard.setType(tempString);
                CfMLangStringType tempLangStringVi = CfMLangStringType.Factory.newInstance();
                tempLangStringVi.setLang("vi");
                tempLangStringVi.setStringValue(tccn.getTentiengviet());

                CfMLangStringType tempLangStringEn = CfMLangStringType.Factory.newInstance();
                tempLangStringEn.setLang("en");
                tempLangStringEn.setStringValue(tccn.getTentienganh());

                tempString.setStringValue(tccn.getSogiaychungnhan());
                standard.setTitleArray(new CfMLangStringType[] { tempLangStringVi, tempLangStringEn });
                standard.setDecisionNumber(tempString);
                metaType.set(standardDoc);

                Calendar pubC = Calendar.getInstance();
                pubC.setTime(tccn.getNgaycongnhan());
                
                CfDateType tempDate = CfDateType.Factory.newInstance();
                tempDate.set(tempDate);
                standard.setPublicationDate(tempDate);
            }

            if (!"".equals(from) && from != null) {
                System.out.println("Have from");
            }
            if (!"".equals(to) && to != null) {
                System.out.println("Have to");
            }
            return doc.xmlText();
        }
        else {
            return verb;
        }
    }
}