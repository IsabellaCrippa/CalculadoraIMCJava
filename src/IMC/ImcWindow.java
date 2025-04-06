package IMC;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class ImcWindow extends JFrame {
    
    private JLabel lblIndice, lblPeso, lblAltura, lblKg, lblMetros, lblResultado, lblPesoIdeal, lblImc, lbltexto;
    private JLabel lblResultadoPesoIdeal, lblResultadoImc, lblResultadoInterpretacao;
    private JTextField txfAltura, txfPeso;
    private JButton btnCalcular, btnLimpar;
    private JPanel pnlTopo, pnlMeio;
    
    public ImcWindow() {
        setTitle("IMC");
        setSize(400, 500);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentesCriar();
        setVisible(true);
    }
    
    private void componentesCriar() {
    	lblIndice = new JLabel("Índice de Massa Corporal (IMC)");
        lblIndice.setBounds(0, 0, 400, 30);
        lblIndice.setForeground(Color.WHITE);
        getContentPane().add(lblIndice);
        
        //obs.: o Que que que seja escrito por cima do azul, deve ser escrito por com
        pnlTopo = new JPanel();
        pnlTopo.setBounds(0, 0, 400, 30);
        pnlTopo.setBackground(Color.BLUE);
        getContentPane().add(pnlTopo);
        
        
        
        lblPeso = new JLabel("Peso");
        lblPeso.setBounds(10, 40, 50, 20);
        getContentPane().add(lblPeso);
        
        txfPeso = new JTextField();        
        txfPeso.setBounds(10, 60, 250, 25);
        getContentPane().add(txfPeso);
        
        lblKg = new JLabel("Kg");
        lblKg.setBounds(270, 60, 30, 25);
        getContentPane().add(lblKg);
        
        lblAltura = new JLabel("Altura");
        lblAltura.setBounds(10, 90, 50, 20);
        getContentPane().add(lblAltura);
        
        txfAltura = new JTextField();        
        txfAltura.setBounds(10, 110, 250, 25);
        getContentPane().add(txfAltura);
        
        lblMetros = new JLabel("m");
        lblMetros.setBounds(270, 110, 30, 25);
        getContentPane().add(lblMetros);
        
        btnCalcular = new JButton("CALCULAR");
        btnCalcular.setBounds(10, 150, 300, 30);
        btnCalcular.setBackground(Color.LIGHT_GRAY);
        btnCalcular.addActionListener(e -> {
            try {
            	String alturaTexto = txfAltura.getText().replace(",", ".");
            	double altura = Double.parseDouble(alturaTexto);

            	String pesoTexto = txfPeso.getText().replace(",", ".");
            	double peso = Double.parseDouble(pesoTexto);


                double imc = FuncaoImc.calcularImc(peso, altura);
                String interpretacao = FuncaoImc.interpretarImc(imc);
                String pesoIdeal = FuncaoImc.calcularPesoIdeal(altura);

                lblResultadoImc.setText(String.format("%.2f", imc));
                lblResultadoInterpretacao.setText(interpretacao);
                lblResultadoPesoIdeal.setText(pesoIdeal);

            } catch (NumberFormatException ex) {
                lblResultadoImc.setText("Erro");
                lblResultadoInterpretacao.setText("Valores inválidos");
                lblResultadoPesoIdeal.setText("!!!!!!!!!!!!!!!!");
            }
        });
        getContentPane().add(btnCalcular);
        
        lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(10, 190, 100, 25);
        getContentPane().add(lblResultado);
        
        lblPesoIdeal = new JLabel("Peso ideal:");
        lblPesoIdeal.setBounds(10, 220, 100, 25);
        getContentPane().add(lblPesoIdeal);
        
        lblResultadoPesoIdeal = new JLabel("___________");
        lblResultadoPesoIdeal.setBounds(120, 220, 100, 25);
        getContentPane().add(lblResultadoPesoIdeal);
        
        lblImc = new JLabel("IMC:");
        lblImc.setBounds(10, 250, 100, 25);
        getContentPane().add(lblImc);
        
        lblResultadoImc = new JLabel("___________");
        lblResultadoImc.setBounds(120, 250, 100, 25);
        getContentPane().add(lblResultadoImc);
        
        lbltexto = new JLabel("Interpretação:");
        lbltexto.setBounds(10, 280, 100, 25);
        getContentPane().add(lbltexto);
        
        lblResultadoInterpretacao = new JLabel("___________");
        lblResultadoInterpretacao.setBounds(120, 280, 200, 25);
        getContentPane().add(lblResultadoInterpretacao);
        
        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setBounds(10, 330, 300, 30);
        btnLimpar.setBackground(Color.LIGHT_GRAY);
                                   // esse "e" é tipo assim, ele é um versão resumida de ActionListener(ação listada) que vem seguida de um override(escrever por cima)
        btnLimpar.addActionListener(e -> {
        FuncaoImc.limparResultados(lblResultadoImc, lblResultadoInterpretacao, lblResultadoPesoIdeal);
         getContentPane().add(btnLimpar);
        });
        
    }
    
    public static void main(String[] args) {
        new ImcWindow();
    }
}
