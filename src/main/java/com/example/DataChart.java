package com.example;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataChart extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    public DataChart(String title) {
        super(title);

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(
                "QS",
                "ArrayLen",
                "Loops",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("QucikSort");
        for (Map.Entry<Integer, Integer> m : App.data.entrySet()) {
            series.add(m.getKey(), m.getValue());
        }
        dataset.addSeries(series);

        return dataset;
    }

    public static void Chart() {
        SwingUtilities.invokeLater(() -> {
            DataChart example = new DataChart("QucikSort Graph");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}