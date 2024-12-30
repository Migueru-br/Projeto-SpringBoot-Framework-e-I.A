package com.miguel.Spring.Controller;

import org.springframework.web.bind.annotation.*;
import com.miguel.Spring.models.Input;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.util.Map;
import java.util.HashMap;

@Controller
public class PredicaoController {
    @RequestMapping(value = "/predict", method = RequestMethod.GET)
    public String getMethodName() {
        return "evento/previsao";
    }

    @SuppressWarnings("null")
    @RequestMapping(value = "/predict", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> predict(@RequestBody Input input) {
        try {
            // Simula a chamada à API da IA e captura a resposta
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("id_resp_p", input.getId_resp_p());
            requestData.put("flow_pkts_payload_avg", input.getFlow_pkts_payload_avg());
            requestData.put("flow_iat_min", input.getFlow_iat_min());
            requestData.put("fwd_pkts_payload_min", input.getFwd_pkts_payload_min());
            requestData.put("bwd_subflow_bytes", input.getBwd_subflow_bytes());
            requestData.put("fwd_data_pkts_tot", input.getFwd_data_pkts_tot());
            requestData.put("id_orig_p", input.getId_orig_p());
            requestData.put("flow_pkts_payload_min", input.getFlow_pkts_payload_min());
            requestData.put("active_min", input.getActive_min());
            requestData.put("flow_pkts_payload_max", input.getFlow_pkts_payload_max());
            requestData.put("service", input.getService());
            requestData.put("proto", input.getProto());

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map<String, String>> response = restTemplate.exchange(
                    "http://localhost:8000/predict",
                    HttpMethod.POST,
                    new HttpEntity<>(requestData),
                    new ParameterizedTypeReference<Map<String, String>>() {
                    });

            // Retorna a resposta no formato JSON
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Erro ao classificar: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}