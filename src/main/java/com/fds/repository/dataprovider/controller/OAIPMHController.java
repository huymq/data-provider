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
import eu.openaire.cerifProfile.x11.OrgUnitDocument.OrgUnit;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard.Editors;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard.EquivalentTo;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard.NomativeReferences;
import eu.openaire.cerifProfile.x11.StandardDocument.Standard.ReplacedBy;

import com.fds.repository.dataprovider.model.TieuChuan;
import com.fds.repository.dataprovider.service.TieuChuanService;

@RestController
@RequestMapping("/oai")
public class OAIPMHController {
	public static final Logger logger = LoggerFactory.getLogger(OAIPMHController.class);

	@Autowired
    private TieuChuanService tieuChuanService;

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
	public String processOAIRequest(@QueryParam("verb") String verb, @QueryParam("set") String set,
			@QueryParam("identifier") String identifier,
			@QueryParam("from") String from, @QueryParam("to") String to) {
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
		} else if ("ListSets".contentEquals(verb)) {
			Calendar c = Calendar.getInstance();

			OAIPMHDocument doc = OAIPMHDocument.Factory.newInstance();
			OAIPMHtype type = doc.addNewOAIPMH();
			c.setTime(new Date());
			type.setResponseDate(c);
			RequestType request = type.addNewRequest();
			request.setStringValue("http://an.oa.org/OAI-script");
			request.setVerb(org.openarchives.oai.x20.VerbType.Enum.forString("ListSets"));
			ListSetsType listSetType = type.addNewListSets();
			
			SetType setType = null;
			
			setType = listSetType.addNewSet();
			setType.setSetName("OpenAIRE_CRIS_publications");
			setType.setSetSpec("openaire_cris_publications");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_products");
			setType.setSetSpec("OpenAIRE_CRIS_products");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_patents");
			setType.setSetSpec("OpenAIRE_CRIS_patents");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_persons");
			setType.setSetSpec("OpenAIRE_CRIS_persons");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_orgunits");
			setType.setSetSpec("OpenAIRE_CRIS_orgunits");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_projects");
			setType.setSetSpec("OpenAIRE_CRIS_projects");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_funding");
			setType.setSetSpec("OpenAIRE_CRIS_funding");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_events");
			setType.setSetSpec("OpenAIRE_CRIS_events");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_journals");
			setType.setSetSpec("OpenAIRE_CRIS_journals");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_equipments");
			setType.setSetSpec("OpenAIRE_CRIS_equipments");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_techs");
			setType.setSetSpec("OpenAIRE_CRIS_techs");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_standards");
			setType.setSetSpec("OpenAIRE_CRIS_standards");
			
			setType = listSetType.addNewSet();
			setType.setSetName("openaire_cris_awards");
			setType.setSetSpec("OpenAIRE_CRIS_awards");
			
			return doc.xmlText();
		} else if ("ListRecords".contentEquals(verb)) {
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
			
			if("openaire_cris_standards".equals(set)) {
				ListRecordsType lstRecordType = type.addNewListRecords();
				List<TieuChuan> lstTieuChuan = tieuChuanService.findAll();

				for (TieuChuan tieuChuan : lstTieuChuan) {
					RecordType recordType = lstRecordType.addNewRecord();
					MetadataType metaType = recordType.addNewMetadata();
					StandardDocument standardDoc = StandardDocument.Factory.newInstance();
					Standard standard = standardDoc.addNewStandard();
					
					standard.setId(String.valueOf(tieuChuan.getId()));
					
					CfStringType tempString = CfStringType.Factory.newInstance();
					tempString.setStringValue("TCVN");
					
					standard.setType(tempString);
					
					tempString.setStringValue(tieuChuan.getSoHieu());
					standard.setIdentifier(tempString);
					
					CfMLangStringType tempLangStringVi = CfMLangStringType.Factory.newInstance();
					tempLangStringVi.setLang("vi");
					tempLangStringVi.setStringValue(tieuChuan.getTenTiengViet());

					CfMLangStringType tempLangStringEn = CfMLangStringType.Factory.newInstance();
					tempLangStringEn.setLang("en");
					tempLangStringEn.setStringValue(tieuChuan.getTenTiengAnh());

					if(tieuChuan.getThoiGianBatDau() != null) {
						CfDateType publicationDate = standard.addNewPublicationDate();
						publicationDate.setDateValue(tieuChuan.getThoiGianBatDau());
						standard.setPublicationDate(publicationDate);
					}
					
					standard.setTitleArray(new CfMLangStringType[] { tempLangStringVi, tempLangStringEn });
					
					if("A".equalsIgnoreCase(tieuChuan.getTinhTrang())) {
						tempString.setStringValue("A - Còn hiệu lực");
						standard.setStatus(tempString);
					} else if("H".equalsIgnoreCase(tieuChuan.getTinhTrang())) {
						tempString.setStringValue("W - Hết hiệu lực");
						standard.setStatus(tempString);
					}
					
					tempString.setStringValue(tieuChuan.getChiSoPhanLoai());
					standard.setSubjectArray(new CfStringType[] {tempString});
					
					tempString.setStringValue(String.valueOf(tieuChuan.getSoTrang()));
					standard.setPage(tempString);
					
					tempString.setStringValue(tieuChuan.getPhamViApDung());
					standard.setScopeArray(new CfStringType[] {tempString});
					
					tempString.setStringValue(tieuChuan.getQuyetDinhBanHanh());
					standard.setDecisionNumber(tempString);
					
					tempString.setStringValue(tieuChuan.getThayTheBang());
					EquivalentTo equivalentTo = EquivalentTo.Factory.newInstance();
					equivalentTo.addNewStandard().setIdentifier(tempString);
					standard.setEquivalentToArray(new EquivalentTo[] {equivalentTo});
					
					tempString.setStringValue(tieuChuan.getThayTheCho());
					ReplacedBy replacedBy = ReplacedBy.Factory.newInstance();
					replacedBy.addNewStandard().setIdentifier(tempString);
					standard.setReplacedByArray(new ReplacedBy[] {replacedBy});
					
					tempString.setStringValue(tieuChuan.getTieuChuanVienDan());
					NomativeReferences nomativeReferences = NomativeReferences.Factory.newInstance();
					nomativeReferences.addNewStandard().setIdentifier(tempString);
					standard.setNomativeReferencesArray(new NomativeReferences[] {nomativeReferences});
					
					//TODO: query ban ky thuat
					OrgUnitDocument orgUnitDocument = OrgUnitDocument.Factory.newInstance();
					OrgUnit orgUnit = orgUnitDocument.addNewOrgUnit();
					orgUnit.setId(String.valueOf(tieuChuan.getIdBanKyThuat()));
					
					tempString.setStringValue("NAVIS");
					orgUnit.setAcronym(tempString);
					
					tempLangStringVi.setStringValue("Trung tâm Quốc tế Nghiên cứu và Phát triển Công nghệ định vị sử dụng vệ tinh");
					tempLangStringEn.setStringValue("NAVIS");
					orgUnit.setNameArray(new CfMLangStringType[] { tempLangStringVi, tempLangStringEn });
					
					Editors editors = standard.addNewEditors();
					editors.addNewEditor().set(orgUnitDocument);
					
					metaType.set(standardDoc);

				}
			}

			return doc.xmlText();
		} else {
			return verb;
		}
	}
}