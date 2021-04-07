package br.edu.utfpr.weight_converter.services;

import br.edu.utfpr.weight_converter.controllers.WeightConverterController;
import br.edu.utfpr.weight_converter.models.dao.ConverterDAO;
import br.edu.utfpr.weight_converter.models.domain.Converter;
import br.edu.utfpr.weight_converter.models.domain.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterService extends AbstractService<Long, Converter> {

    protected ConverterDAO convertDao;
    private UserService userService;

    public ConverterService () {
        this.convertDao = new ConverterDAO();
        this.userService = new UserService();
    }

    public String convertValue(Map<String, String> calculationSettings) {
        Map<String, String> calculationResponse = new HashMap<String, String>();
        calculationResponse.put("kg", this.kgToG(new BigDecimal(calculationSettings.get("value"))));
        calculationResponse.put("g", this.gToKg(new BigDecimal(calculationSettings.get("value"))));

        Map<String, BigDecimal> calculationFunction = new HashMap<String, BigDecimal>();
        calculationFunction.put("kg", this.calculationKgToG(new BigDecimal(calculationSettings.get("value"))));
        calculationFunction.put("g", this.calculationGToKg(new BigDecimal(calculationSettings.get("value"))));

        User user = this.userService.findByName(WeightConverterController.identity);

        if(!calculationSettings.isEmpty()) {
            Converter converter = new Converter(
                    new BigDecimal(calculationSettings.get("value")),
                    calculationSettings.get("for"),
                    calculationSettings.get("to"),
                    calculationFunction.get(calculationSettings.get("for"))
            );
            converter.setUser(user);
            this.save(converter);
            return calculationResponse.get(calculationSettings.get("for"));
        }
        return null;
    }

    public List<String> getLastConvertions() {
        List<String> result = new ArrayList<String>();
        List<Converter> convertions = this.convertDao.findLastFive();
        if(convertions.size() > 5) {
            int limit = 5;
            for(int i = 0; i < limit; i++) {
                result.add(convertions.get(i).getInitValue().toString() + " " + convertions.get(i).getUnityFor() + " = " + convertions.get(i).getResultValue() + " " + convertions.get(i).getUnityTo());
            }
        } else {
            for(int i = 0; i < convertions.size(); i++) {
                result.add(convertions.get(i).getInitValue().toString() + " " + convertions.get(i).getUnityFor() + " = " + convertions.get(i).getResultValue() + " " + convertions.get(i).getUnityTo());
            }
        }

        return result;
    }

    public String kgToG(BigDecimal kgValue) {
        String result = kgValue.multiply(new BigDecimal(1000)).toString();
        return (kgValue.toString() + " Kg = " + result + " g");
    }

    public BigDecimal calculationKgToG(BigDecimal kgValue) {
        return kgValue.multiply(new BigDecimal(1000));
    }

    public String gToKg(BigDecimal gValue) {
        String result = gValue.divide(new BigDecimal(1000)).toString();
        return (gValue.toString() + " g = " + result + " Kg");
    }

    public BigDecimal calculationGToKg(BigDecimal gValue) {
        return gValue.divide(new BigDecimal(1000));
    }

}
