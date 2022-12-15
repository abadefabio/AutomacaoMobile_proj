package constantes.cockpit;

import org.json.simple.JSONObject;

public class DadosAprovacaoJson {

    private String dados;

    public String getDados() {

        dados = "{\n" +
                "    \"sequenceProposalUid\": 2,\n" +
                "    \"detailProspectProposal\": null,\n" +
                "    \"checkVideoSelfie\": 1,\n" +
                "    \"checkDocumentGuard\": 2,\n" +
                "    \"customerMessage\": \"\",\n" +
                "    \"tempest\": {\n" +
                "        \"tempestAddressCheckedInd\": null\n" +
                "    },\n" +
                "    \"customer\": {\n" +
                "        \"customerUid\": null\n" +
                "    },\n" +
                "    \"listAttachmentDocuments\": [],\n" +
                "    \"listDocumentRequestProposal\": [\n" +
                "        {\n" +
                "            \"additionalDocument\": false,\n" +
                "            \"typeApprovalDocumentId\": 1,\n" +
                "            \"resendDocUid\": null,\n" +
                "            \"docRequestProposalUid\": 281034,\n" +
                "            \"docVisualization\": false,\n" +
                "            \"documentType\": {\n" +
                "                \"docTypeUid\": 2,\n" +
                "                \"documentTypeName\": \"RG COM CPF\",\n" +
                "                \"documentNameView\": \"DOCUMENTO IDENTIFICAÇÃO\",\n" +
                "                \"isDocument\": true\n" +
                "            },\n" +
                "            \"detailDocumentProposal\": {\n" +
                "                \"documentId\": 73332,\n" +
                "                \"journey\": \"Adesão\",\n" +
                "                \"documentName\": \"5475230101334020220222135128878801Z.JPEG\",\n" +
                "                \"uploadDate\": \"2022-02-22T13:51:28.878801\",\n" +
                "                \"mimeType\": \"IMAGE/JPEG\",\n" +
                "                \"checkVideoSelfie\": null,\n" +
                "                \"alertDocumentAddress\": \"\",\n" +
                "                \"alertDocumentLiveness\": \"\",\n" +
                "                \"fileInfected\": false,\n" +
                "                \"isShowLink\": true,\n" +
                "                \"alertDocumentFileInfected\": \"\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"additionalDocument\": false,\n" +
                "            \"typeApprovalDocumentId\": 1,\n" +
                "            \"resendDocUid\": null,\n" +
                "            \"docRequestProposalUid\": 9528221,\n" +
                "            \"docVisualization\": false,\n" +
                "            \"documentType\": {\n" +
                "                \"docTypeUid\": 5,\n" +
                "                \"documentTypeName\": \"Video\",\n" +
                "                \"documentNameView\": \"VÍDEO SELFIE\",\n" +
                "                \"isDocument\": true\n" +
                "            },\n" +
                "            \"detailDocumentProposal\": {\n" +
                "                \"documentId\": 11354024,\n" +
                "                \"journey\": \"Adesão\",\n" +
                "                \"documentName\": \"9195230101334020220222135127647720Z.MP4\",\n" +
                "                \"uploadDate\": \"2022-02-22T13:51:27.64772\",\n" +
                "                \"mimeType\": \"VIDEO/MP4\",\n" +
                "                \"checkVideoSelfie\": 1,\n" +
                "                \"alertDocumentAddress\": \"\",\n" +
                "                \"alertDocumentLiveness\": \"\",\n" +
                "                \"fileInfected\": null,\n" +
                "                \"isShowLink\": true,\n" +
                "                \"alertDocumentFileInfected\": \"\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"typeApprovalDocumentId\": 1,\n" +
                "            \"resendDocUid\": null,\n" +
                "            \"docRequestProposalUid\": null,\n" +
                "            \"additionalDocument\": false,\n" +
                "            \"documentType\": {\n" +
                "                \"docTypeUid\": 4,\n" +
                "                \"documentTypeName\": \"COMPROVANTE DE ENDEREÇO\",\n" +
                "                \"documentNameView\": \"COMPROVANTE DE ENDEREÇO\",\n" +
                "                \"isDocument\": true\n" +
                "            },\n" +
                "            \"detailDocumentProposal\": {\n" +
                "                \"documentId\": null,\n" +
                "                \"alertDocumentAddress\": \"Necessário validação da Gestão da Operação\",\n" +
                "                \"fileInfected\": null,\n" +
                "                \"isShowLink\": false\n" +
                "            },\n" +
                "            \"docVisualization\": true\n" +
                "        }\n" +
                "    ],\n" +
                "    \"internalRevenueProspect\": {\n" +
                "        \"revenueAgencyCode\": {\n" +
                "            \"value\": \"00\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"revenueAgencyDescription\": {\n" +
                "            \"value\": \"ATIVA\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"revenueAgencyStatusId\": {\n" +
                "            \"value\": null,\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"revenueAgencyIsPEP\": {\n" +
                "            \"value\": \"N\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"revenueAgencyGender\": {\n" +
                "            \"value\": \"M\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"revenueAgencyMotherName\": {\n" +
                "            \"value\": \"FULANA DA SILVA\",\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"revenueAgencyCustomerName\": {\n" +
                "            \"value\": \"FULANO BELTRANO DA SILVA PERFIL NOVO\",\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"revenueAgencyBirthDt\": {\n" +
                "            \"value\": \"1957-03-17\",\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"registrationName\": \"FULANO BELTRANO DA SILVA PERFIL NOVO\",\n" +
                "        \"motherName\": \"FULANA DA SILVA\",\n" +
                "        \"birthdate\": \"1957-03-17\",\n" +
                "        \"matchRevenue\": {\n" +
                "            \"matchMotherName\": true,\n" +
                "            \"matchCustomerName\": true,\n" +
                "            \"matchBirthDate\": true\n" +
                "        }\n" +
                "    },\n" +
                "    \"prospectRegistrationData\": {\n" +
                "        \"cpf\": {\n" +
                "            \"value\": \"52301013340\",\n" +
                "            \"correctValue\": \"\",\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"emissionDate\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"registrationName\": {\n" +
                "            \"value\": \"FULANO BELTRANO DA SILVA PERFIL NOVO\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"birthDate\": {\n" +
                "            \"value\": \"1957-03-17\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"cityOfBirth\": {\n" +
                "            \"value\": \"50830\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"civilCapacityCode\": {\n" +
                "            \"value\": \"0\",\n" +
                "            \"correctValue\": \"\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"countryOfBirth\": {\n" +
                "            \"value\": \"46\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"documentType\": {\n" +
                "            \"value\": \"3\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"documentIssueDate\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": \"2022-02-22\",\n" +
                "            \"typeConference\": 2\n" +
                "        },\n" +
                "        \"documentIssuerDepartment\": {\n" +
                "            \"value\": \"SSP\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"documentIssuerStateId\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": \"SP\",\n" +
                "            \"typeConference\": 2\n" +
                "        },\n" +
                "        \"numDoc\": {\n" +
                "            \"value\": \"846537846\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"email\": {\n" +
                "            \"value\": \"api@automation.com\",\n" +
                "            \"correctValue\": \"\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"missingFatherNameReasonId\": false,\n" +
                "        \"fatherName\": {\n" +
                "            \"value\": \"FULANO DA SILVA\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"gender\": {\n" +
                "            \"value\": \"M\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"missingMotherNameReasonId\": false,\n" +
                "        \"motherName\": {\n" +
                "            \"value\": \"FULANA DA SILVA\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"stateCityPlaceOfBirth\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"birthPlace\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": \"\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"documentCity\": {\n" +
                "            \"value\": null,\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 2\n" +
                "        },\n" +
                "        \"spouseName\": \"STRING STRING\",\n" +
                "        \"stateOfBirth\": {\n" +
                "            \"value\": \"11\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"typeOfDocument\": \"Carteira Nacional Habilitação\",\n" +
                "        \"twitterAccount\": \"string\",\n" +
                "        \"universityStudentInd\": \"Y\",\n" +
                "        \"universityStudentChangedInd\": \"N\",\n" +
                "        \"tempestRetryCount\": null,\n" +
                "        \"branch\": null,\n" +
                "        \"gpsPermissionInd\": true,\n" +
                "        \"pinPointChangedInd\": true,\n" +
                "        \"pinPointLatitude\": \"string\",\n" +
                "        \"pinPointLongitude\": \"string\",\n" +
                "        \"eduInstitutionStateCd\": \"SP\",\n" +
                "        \"eduCurrentSemester\": 0,\n" +
                "        \"eduLastUpdatedDt\": \"2020-05-27\",\n" +
                "        \"eduCompletionDt\": \"2020-05-27\",\n" +
                "        \"educationLevelId\": 0,\n" +
                "        \"eduMajor\": \"string\",\n" +
                "        \"eduInstitutionName\": \"string string\",\n" +
                "        \"moneyLenderFlag\": null,\n" +
                "        \"professionCategoryId\": 1,\n" +
                "        \"professionId\": 100,\n" +
                "        \"referencePersonTypeId\": 0,\n" +
                "        \"referencePersonName\": \"Valentina Silva\",\n" +
                "        \"referencePersonCountryCode\": 0,\n" +
                "        \"referencePersonAreaCode\": 0,\n" +
                "        \"referencePersonPhoneNr\": 0,\n" +
                "        \"monthlyIncome\": \"1.000,00\",\n" +
                "        \"nickname\": \"VAL\",\n" +
                "        \"pepRoleId\": null,\n" +
                "        \"pepRelatedId\": 0,\n" +
                "        \"pepRelatedCpf\": null,\n" +
                "        \"pepRoleResponse\": \"N\",\n" +
                "        \"pepRelatedResponse\": \"N\",\n" +
                "        \"influencerInd\": null,\n" +
                "        \"invoiceDay\": 0,\n" +
                "        \"maritalStatus\": 1,\n" +
                "        \"cellphone\": {\n" +
                "            \"primaryPhone\": true,\n" +
                "            \"countryCode\": \"55\",\n" +
                "            \"areaCode\": \"11\",\n" +
                "            \"phoneNumber\": 951254825\n" +
                "        },\n" +
                "        \"phone\": {\n" +
                "            \"primaryPhone\": null,\n" +
                "            \"countryCode\": null,\n" +
                "            \"areaCode\": null,\n" +
                "            \"phoneNumber\": null\n" +
                "        },\n" +
                "        \"politicallyExposedPersonRelationship\": false,\n" +
                "        \"revenueMotherName\": \"FULANA DA SILVA\",\n" +
                "        \"revenueCustomerGender\": \"M\",\n" +
                "        \"dependentManagementDto\": {\n" +
                "            \"responsibleCustomer\": {\n" +
                "                \"customerUid\": null,\n" +
                "                \"cpf\": null,\n" +
                "                \"customerName\": null,\n" +
                "                \"branch\": null,\n" +
                "                \"branchCheckDigit\": null,\n" +
                "                \"account\": null,\n" +
                "                \"accountDigit\": null,\n" +
                "                \"externalHashId\": null\n" +
                "            },\n" +
                "            \"relationshipDegree\": {\n" +
                "                \"value\": null,\n" +
                "                \"correctValue\": null,\n" +
                "                \"typeConference\": null\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"addressProspectProposal\": {\n" +
                "        \"addressAdditionalInfo\": {\n" +
                "            \"value\": \"BLOCO XPTO\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"mailingAddressInd\": {\n" +
                "            \"value\": \"Y\",\n" +
                "            \"correctValue\": \"\",\n" +
                "            \"typeConference\": null\n" +
                "        },\n" +
                "        \"postalCode\": {\n" +
                "            \"value\": \"4601010\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"neighbourhood\": {\n" +
                "            \"value\": \"Brooklin\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 3\n" +
                "        },\n" +
                "        \"stateCode\": {\n" +
                "            \"value\": \"SP\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"streetName\": {\n" +
                "            \"value\": \"RUA ASSIS BRASIL\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"city\": {\n" +
                "            \"value\": \"0\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        },\n" +
                "        \"streetNumber\": {\n" +
                "            \"value\": \"100\",\n" +
                "            \"correctValue\": null,\n" +
                "            \"typeConference\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    \"proposalAnalysisDecision\": {\n" +
                "        \"analysisDecisionUid\": 1,\n" +
                "        \"analysisReasonUid\": null,\n" +
                "        \"descriptionAnalysis\": \"test cockpit squad 10\"\n" +
                "    },\n" +
                "    \"startDateAnalysis\": \"2022-02-22 14:01:00\"\n" +
                "}\n";
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    DadosAprovacaoJson dadosAprovacaoJson(){
        return this;
    }

}
