package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Model.Person;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CSVHandler {
    public static List<Person> importCSV(String filePath) {
        List<Person> persons = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Ignora a primeira linha (cabeçalhos)
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 23) {  // Verifica se a linha tem o número correto de colunas
                    Person person = new Person();
                    person.setNome(values[0]);
                    person.setIdade(Integer.parseInt(values[1]));
                    person.setCpf(values[2]);
                    person.setRg(values[3]);
                    person.setDataNasc(values[4]);
                    person.setSexo(values[5]);
                    person.setSigno(values[6]);
                    person.setMae(values[7]);
                    person.setPai(values[8]);
                    person.setEmail(values[9]);
                    person.setSenha(values[10]);
                    person.setCep(values[11]);
                    person.setEndereco(values[12]);
                    person.setNumero(values[13]);
                    person.setBairro(values[14]);
                    person.setCidade(values[15]);
                    person.setEstado(values[16]);
                    person.setTelefoneFixo(values[17]);
                    person.setCelular(values[18]);
                    person.setAltura(values[19]);
                    person.setPeso(values[20]);
                    person.setTipoSanguineo(values[21]);
                    person.setCor(values[22]);
                    persons.add(person);
                } else {
                    System.err.println("Linha com número incorreto de colunas: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao importar arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return persons;
    }

    public static void exportCSV(String filePath, List<Person> persons) {
        if (persons == null || persons.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há dados para exportar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PrintWriter pw = new PrintWriter(new File(filePath))) {
            // Escreve os cabeçalhos
            pw.println("Nome,Idade,CPF,RG,DataNasc,Sexo,Signo,Mae,Pai,Email,Senha,CEP,Endereco,Numero,Bairro,Cidade,Estado,TelefoneFixo,Celular,Altura,Peso,TipoSanguineo,Cor");
            
            // Escreve os dados
            for (Person person : persons) {
                pw.println(person.getNome() + "," + person.getIdade() + "," + person.getCpf() + "," + person.getRg() + "," +
                           person.getDataNasc() + "," + person.getSexo() + "," + person.getSigno() + "," + person.getMae() + "," +
                           person.getPai() + "," + person.getEmail() + "," + person.getSenha() + "," + person.getCep() + "," +
                           person.getEndereco() + "," + person.getNumero() + "," + person.getBairro() + "," + person.getCidade() + "," +
                           person.getEstado() + "," + person.getTelefoneFixo() + "," + person.getCelular() + "," + person.getAltura() + "," +
                           person.getPeso() + "," + person.getTipoSanguineo() + "," + person.getCor());
            }
            JOptionPane.showMessageDialog(null, "Arquivo exportado com sucesso! Verifique o caminho: " + filePath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
