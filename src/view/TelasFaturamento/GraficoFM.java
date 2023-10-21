/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.TelasFaturamento;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author gilberto
 */
public class GraficoFM extends JFrame {
 Double valor=0.0;
    public GraficoFM(Double valor) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Grafico Faturamento");
        setSize(900, 700);
        setLocationRelativeTo(null);
        criarGrafico(valor);
        setVisible(true);
        setResizable(false);
        this.valor=valor;

    }

    public void criarGrafico(Double valor) {
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        Double record = 187750.0;
        Double meta = (record * 70 / 100);
        barra.setValue(record, "Record", "Record                                 ");
        barra.setValue(meta, "Meta", "Meta");
        barra.setValue(valor, "Atual", "                                     Valor");
        
        
        
        //=================CRIAÇÃO E PERSONALIZAÇÃO DO GRAFICO ======================================
        JFreeChart grafico = ChartFactory.createBarChart3D("Grafico Faturamento", "Faturamento", "R$", barra, PlotOrientation.VERTICAL, false, true, false);
        final CategoryPlot p = grafico.getCategoryPlot();
        BarRenderer rend = (BarRenderer) p.getRenderer();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        rend.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalFormat));
        p.setRenderer(rend);
        //=================SETANDO FONTE DO GRAFICO=================================================
        Font font3 = new Font("Dialog", Font.PLAIN, 25);
        p.getDomainAxis().setLabelFont(font3);
        p.getRangeAxis().setLabelFont(font3);
        //=================SETANDO NUMERO ACIMA DO GRAFICO==========================================
        rend.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT));
        rend.setItemLabelsVisible(true);
        grafico.getCategoryPlot().setRenderer(rend);
        //=================SETANDO COR DAS LINHAS DE FUNDO DO GRAFICO==============================
        p.setRangeGridlinePaint(Color.BLACK);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
        setVisible(true);
        
            
    }
    
    

}
