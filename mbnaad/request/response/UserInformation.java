package com.td.mbna.msec.midtier.mbnaad.request.response;

import java.io.Serializable;

public class UserInformation implements Serializable {
        private Boolean reissueInd;

        private DeliveryInfo deliveryInfo;

        private String cardNum;

        private CardInfo cardInfo;

        private Boolean chargeFeeInd;

        private Integer numberOfCardCnt;

        private String partyKey;

        private String reasonCd;

        public Boolean getReissueInd() {
            return this.reissueInd;
        }

        public void setReissueInd(Boolean reissueInd) {
            this.reissueInd = reissueInd;
        }

        public DeliveryInfo getDeliveryInfo() {
            return this.deliveryInfo;
        }

        public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
            this.deliveryInfo = deliveryInfo;
        }

        public String getCardNum() {
            return this.cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public CardInfo getCardInfo() {
            return this.cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public Boolean getChargeFeeInd() {
            return this.chargeFeeInd;
        }

        public void setChargeFeeInd(Boolean chargeFeeInd) {
            this.chargeFeeInd = chargeFeeInd;
        }

        public Integer getNumberOfCardCnt() {
            return this.numberOfCardCnt;
        }

        public void setNumberOfCardCnt(Integer numberOfCardCnt) {
            this.numberOfCardCnt = numberOfCardCnt;
        }

        public String getPartyKey() {
            return this.partyKey;
        }

        public void setPartyKey(String partyKey) {
            this.partyKey = partyKey;
        }

        public String getReasonCd() {
            return this.reasonCd;
        }

        public void setReasonCd(String reasonCd) {
            this.reasonCd = reasonCd;
        }

        public static class DeliveryInfo implements Serializable {
            private String deliveryMethodName;

            private Address address;

            public String getDeliveryMethodName() {
                return this.deliveryMethodName;
            }

            public void setDeliveryMethodName(String deliveryMethodName) {
                this.deliveryMethodName = deliveryMethodName;
            }

            public Address getAddress() {
                return this.address;
            }

            public void setAddress(Address address) {
                this.address = address;
            }

            public static class Address implements Serializable {
                private String city;

                private String postalCode;

                private String countryCd;

                private String addressLine1;

                private String addressLine2;

                private String territory;

                private String desc;

                public String getCity() {
                    return this.city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getPostalCode() {
                    return this.postalCode;
                }

                public void setPostalCode(String postalCode) {
                    this.postalCode = postalCode;
                }

                public String getCountryCd() {
                    return this.countryCd;
                }

                public void setCountryCd(String countryCd) {
                    this.countryCd = countryCd;
                }

                public String getAddressLine1() {
                    return this.addressLine1;
                }

                public void setAddressLine1(String addressLine1) {
                    this.addressLine1 = addressLine1;
                }

                public String getAddressLine2() {
                    return this.addressLine2;
                }

                public void setAddressLine2(String addressLine2) {
                    this.addressLine2 = addressLine2;
                }

                public String getTerritory() {
                    return this.territory;
                }

                public void setTerritory(String territory) {
                    this.territory = territory;
                }

                public String getDesc() {
                    return this.desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }
            }
        }

        public static class CardInfo implements Serializable {
            private String typeCd;

            public String getTypeCd() {
                return this.typeCd;
            }

            public void setTypeCd(String typeCd) {
                this.typeCd = typeCd;
            }
        }



}
