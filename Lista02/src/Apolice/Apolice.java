package Apolice;
// @author DaviP

import javax.swing.JOptionPane;

public class Apolice {

    private int numero;
    private String nome;
    private int idade;
    private char sexo;
    private double valorAutomovel;
    private boolean verificar = true;
    private boolean verificaCriar = true;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getValorAutomovel() {
        return valorAutomovel;
    }

    public void setValorAutomovel(double valorAutomovel) {
        this.valorAutomovel = valorAutomovel;
    }

    public double calcularValor() {
        if (sexo == 'M' & idade <= 25) {
            return valorAutomovel * 10 / 100;
        }
        if (sexo == 'M' & idade >= 25) {
            return valorAutomovel * 5 / 100;
        }
        if (sexo == 'F') {
            return valorAutomovel * 2 / 100;
        }
        return calcularValor();
    }

    public String imprimir() {

        return 
                "Numero: " + numero
                + "\nNome: " + nome
                + "\nIdade: " + idade
                + "\nSexo: " + sexo
                + "\nValor do Automovel: " + valorAutomovel
                + "\nValor Apólice: " + calcularValor();
    }
    public void menu() {
        Object[] opcoes = {"Criar Apolice", "Ver Dados Apolice", "Sair"};
        Object[] itens = {"Numero", "Nome", "Idade", "Sexo", "Valor do Automovel", "Voltar"};
        do {
            Object selectValue = JOptionPane.showInputDialog(null,
                    "Escolha uma opção",
                    "Bloco inicial",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (opcoes[0] == selectValue) {
                do {
                    Object selectedValue = JOptionPane.showInputDialog(
                            null,
                            "Escolha uma opção",
                            "Criar Apolice",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            itens,
                            itens[0]);
                    switch (selectedValue.toString()) {
                        case "Numero" -> {
                            String inputNumero = JOptionPane.showInputDialog("Digite o numero: ");
                            setNumero(Integer.parseInt(inputNumero));
                        }
                        case "Nome" -> {
                            String inputNome = JOptionPane.showInputDialog("Digite seu nome: ");
                            setNome(inputNome);
                        }
                        case "Idade" -> {
                            String inputIdade = JOptionPane.showInputDialog("Digite sua Idade: ");
                            setIdade(Integer.parseInt(inputIdade));
                        }
                        case "Sexo" -> {
                            String inputSexo = JOptionPane.showInputDialog("Digite seu Sexo: (M) Masculino (F) Feminino ");
                            setSexo(inputSexo.charAt(0));
                        }
                        case "Valor do Automovel" -> {
                            String inputValorAuto = JOptionPane.showInputDialog("Digite o Valor do Automovel: ");
                            setValorAutomovel(Double.parseDouble(inputValorAuto));
                        }
                        case "Voltar" -> {
                            this.verificaCriar = false;
                        }
                    }
                } while (this.verificaCriar == true );
                
            }
            if (opcoes[1] == selectValue) {
                if (imprimir() == null) {
                    JOptionPane.showConfirmDialog(null, "Please fill the other spaces", "WARNING", JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, imprimir());
            }
            if (opcoes[2] == selectValue) {
                JOptionPane.showConfirmDialog(null, "Deseja Sair?");
                this.verificar = false;
            }
        } while (this.verificar == true);

    }
}