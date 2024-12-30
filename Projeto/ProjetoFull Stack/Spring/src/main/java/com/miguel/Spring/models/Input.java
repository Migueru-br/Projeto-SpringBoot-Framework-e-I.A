package com.miguel.Spring.models;

public class Input {
private float id_resp_p;
private float flow_pkts_payload_avg;
private float flow_iat_min;
private float fwd_pkts_payload_min;
private float bwd_subflow_bytes;
private float fwd_data_pkts_tot;
private float id_orig_p;
private float flow_pkts_payload_min;
private float active_min;
private float flow_pkts_payload_max;
private String service;
private String proto;



public float getId_resp_p() {
    return id_resp_p;
}
public void setId_resp_p(float id_resp_p) {
    this.id_resp_p = id_resp_p;
}
public float getFlow_pkts_payload_avg() {
    return flow_pkts_payload_avg;
}
public void setFlow_pkts_payload_avg(float flow_pkts_payload_avg) {
    this.flow_pkts_payload_avg = flow_pkts_payload_avg;
}
public float getFlow_iat_min() {
    return flow_iat_min;
}
public void setFlow_iat_min(float flow_iat_min) {
    this.flow_iat_min = flow_iat_min;
}
public float getFwd_pkts_payload_min() {
    return fwd_pkts_payload_min;
}
public void setFwd_pkts_payload_min(float fwd_pkts_payload_min) {
    this.fwd_pkts_payload_min = fwd_pkts_payload_min;
}
public float getBwd_subflow_bytes() {
    return bwd_subflow_bytes;
}
public void setBwd_subflow_bytes(float bwd_subflow_bytes) {
    this.bwd_subflow_bytes = bwd_subflow_bytes;
}
public float getFwd_data_pkts_tot() {
    return fwd_data_pkts_tot;
}
public void setFwd_data_pkts_tot(float fwd_data_pkts_tot) {
    this.fwd_data_pkts_tot = fwd_data_pkts_tot;
}
public float getId_orig_p() {
    return id_orig_p;
}
public void setId_orig_p(float id_orig_p) {
    this.id_orig_p = id_orig_p;
}
public float getFlow_pkts_payload_min() {
    return flow_pkts_payload_min;
}
public void setFlow_pkts_payload_min(float flow_pkts_payload_min) {
    this.flow_pkts_payload_min = flow_pkts_payload_min;
}
public float getActive_min() {
    return active_min;
}
public void setActive_min(float active_min) {
    this.active_min = active_min;
}
public float getFlow_pkts_payload_max() {
    return flow_pkts_payload_max;
}
public void setFlow_pkts_payload_max(float flow_pkts_payload_max) {
    this.flow_pkts_payload_max = flow_pkts_payload_max;
}
public String getService() {
    return service;
}
public void setService(String service) {
    this.service = service;
}
public String getProto() {
    return proto;
}
public void setProto(String proto) {
    this.proto = proto;
}

}
