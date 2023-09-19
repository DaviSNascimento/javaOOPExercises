
package Vendedor;

// @author DaviP

import javax.swing.JOptionPane;
        
public class Vendedor {
    private int codigo;
    private String nome;
    private double percentualComissao;
    private boolean verificar = true;
    private boolean verificaCadastro = true;
    private boolean verificaCalc = true;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }
    public double calcularPagamentoComissao(double valorVenda){
        return valorVenda * percentualComissao / 100;
    }
    public double calcularPagamentoComissao(double valorVenda, double desconto){
        return calcularPagamentoComissao(valorVenda) - desconto;
    }
    public String imprimir(double valorVenda,double desconto){
        return
                "Código: " + codigo
                + "\nNome: " + nome
                + "\nValor Venda: " + valorVenda
                + "\n% Comissão: " + percentualComissao
                + "\nDesconto: " + desconto
                + "\nValor a Pagar" + calcularPagamentoComissao(valorVenda);
    }
    public void menu() {
       Object[] opcoes = {"Cadastrar Vendedor", "Calcular Venda", "Mostrar Dados", "Sair"};
       Object[] cadastroVendedor = {"Código", "Nome", "Voltar"};
       Object[] calcVenda = {"Valor Venda", "Valor desconto","Percentual Comissao","Voltar"};
        do {
            Object selectValue = JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção: ",
                    "Bloco Inicial",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);
            if (opcoes[0] == selectValue) {
                do{
                    Object selectedValue = JOptionPane.showInputDialog(null,
                            "Cadastro\n Escolha uma Opção: ",
                            "Cadastro do Vendedor",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            cadastroVendedor,
                            cadastroVendedor[0]);
                    switch(selectedValue.toString()){
                        case "Código" ->{
                            String inputCodigo = JOptionPane.showInputDialog("Insira o Código: ");
                            setCodigo(Integer.parseInt(inputCodigo));
                        }
                        case "Nome" -> {
                            String inputNome = JOptionPane.showInputDialog("Insira o Nome: ");
                            setNome(inputNome);
                        }
                        case "Voltar" ->{
                            this.verificaCadastro = false;
                        }
                    }
                }while (this.verificaCadastro == true);
            }
            if(opcoes[1] == selectValue){
                                
                do {      
                    Object selectedValue = JOptionPane.showInputDialog(null,
                        "Calcule a Venda",
                        "Calcular Venda",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        calcVenda,
                        calcVenda[0]);
                
                    switch(selectedValue.toString()){
                        case "Valor Venda" -> {
                            String inputValorVenda = JOptionPane.showInputDialog("Insira o Valor da venda:");
                            calcularPagamentoComissao(Double.parseDouble(inputValorVenda));
                        }
                        case "Valor desconto" ->{
                            String inputValorDesconto = JOptionPane.showInputDialog("Insira o percentual do Desconto: ");
                            calcularPagamentoComissao(calcularPagamentoComissao(percentualComissao), Double.parseDouble(inputValorDesconto));
                        }
                        case "Percentual Comissao" ->{
                            String inputPercentualComissao = JOptionPane.showInputDialog("Insira o percentual de Comissão: ");
                            setPercentualComissao(Double.parseDouble(inputPercentualComissao));
                        }
                        case "Voltar" ->{
                            this.verificaCalc = false;
                        }
                    }
                } while (this.verificaCalc == true);
            }
            if (opcoes[2] == selectValue) {
                JOptionPane.showMessageDialog(null,imprimir(percentualComissao, percentualComissao));
            }
            if (opcoes[3] == selectValue) {
                JOptionPane.showConfirmDialog(null, "Deseja sair? ");
                this.verificar = false;
            }
        } while (this.verificar == true);
    }
}
