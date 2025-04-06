package IMC;

import javax.swing.JLabel;

public class FuncaoImc {
    
    public static double calcularImc(double peso, double altura) {
    	double imc = peso / (altura * altura);
    	return imc;
    }
    
    public static String interpretarImc(double imc) {
        if (imc < 20) {
            return "Abaixo do peso";
        } else if (imc >= 20 && imc < 25) {
            return "Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Acima do peso";
        } else {
            return "Obeso";
        }
    }

    public static String calcularPesoIdeal(double altura) {
        double alturaCm = altura * 100;
        double pesoIdeal = (alturaCm - 100) - ((alturaCm - 100) * 0.05); 
        return String.format("%.1f kg", pesoIdeal);
    }
    public static void limparResultados(
    	    JLabel lblResultadoImc,
    	    JLabel lblResultadoInterpretacao,
    	    JLabel lblResultadoPesoIdeal
    	) {
    	    lblResultadoImc.setText("___________");
    	    lblResultadoInterpretacao.setText("___________");
    	    lblResultadoPesoIdeal.setText("___________");
    	}

     
}
