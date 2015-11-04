import java.awt.Color;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class LineChart_AWT extends ApplicationFrame
{
   public LineChart_AWT( String applicationTitle , String chartTitle, double[] tStamp, int[] x1, int[] x2, int[] x3, 
		   int[] y1, int[] y2, int[] y3)
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "TimeStamp","Output value",
         createDataset(tStamp, x1, x2, x3, y1, y2, y3),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      
      
//      final XYDataset dataset = createDataset(tStamp, x1, x2, x3, y1, y2, y3);
//      final JFreeChart chart = createChart(dataset);
//      final ChartPanel chartPanel = new ChartPanel(chart);
//      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//      setContentPane(chartPanel);
   }

   private DefaultCategoryDataset createDataset( double[] tStamp, int[] x1, int[] x2, int[] x3, 
		   int[] y1, int[] y2, int[] y3)
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
//	  final XYSeriesCollection dataset = new XYSeriesCollection();
//      final XYSeries seriesX1 = new XYSeries("X1");
//      final XYSeries seriesX2 = new XYSeries("X2");
//      final XYSeries seriesX3 = new XYSeries("X3");
//      final XYSeries seriesY1 = new XYSeries("Y1");
//      final XYSeries seriesY2 = new XYSeries("Y2");
//      final XYSeries seriesY3 = new XYSeries("Y3");
      
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( x1[i], "X1" , tStamp[i] + "");
      }
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( x2[i], "X2" , tStamp[i] + "");
      }
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( x3[i], "X3" , tStamp[i] + "");
      }
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( y1[i], "Y1" , tStamp[i] + "");
      }
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( y2[i], "Y2" , tStamp[i] + "");
      }
      for(int i = 0; i < tStamp.length; i++) {
    	  dataset.addValue( y3[i], "Y3" , tStamp[i] + "");
      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesX1.add(tStamp[i], x1[i]);
//      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesX2.add(tStamp[i], x2[i]);
//      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesX3.add(tStamp[i], x3[i]);
//      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesY1.add(tStamp[i], y1[i]);
//      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesY2.add(tStamp[i], y2[i]);
//      }
//      for(int i = 0; i < tStamp.length; i++) {
//    	  seriesY3.add(tStamp[i], y3[i]);
//      }
//      dataset.addSeries(seriesX1);
//      dataset.addSeries(seriesX2);
//      dataset.addSeries(seriesX3);
//      dataset.addSeries(seriesY1);
//      dataset.addSeries(seriesY2);
//      dataset.addSeries(seriesY3);
//      dataset.addValue( 15 , "schools" , "10" );
//      dataset.addValue( 30 , "schools" , "1980" );
//      dataset.addValue( 60 , "schools" ,  "1990" );
//      dataset.addValue( 120 , "schools" , "2000" );
//      dataset.addValue( 240 , "schools" , "2010" );
//      dataset.addValue( 300 , "schools" , "2014" );
      return dataset;
   }
//   public static void main( String[ ] args ) 
//   {
//      LineChart_AWT chart = new LineChart_AWT(
//      "School Vs Years" ,
//      "Numer of Schools vs years");
//
//      chart.pack( );
//      RefineryUtilities.centerFrameOnScreen( chart );
//      chart.setVisible( true );
//   }
   
   
   private JFreeChart createChart(final XYDataset dataset) {
       
       // create the chart...
       final JFreeChart chart = ChartFactory.createXYLineChart(
           "Line Chart Demo 6",      // chart title
           "X",                      // x axis label
           "Y",                      // y axis label
           dataset,                  // data
           PlotOrientation.VERTICAL,
           true,                     // include legend
           true,                     // tooltips
           false                     // urls
       );

       // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
       chart.setBackgroundPaint(Color.white);

//       final StandardLegend legend = (StandardLegend) chart.getLegend();
 //      legend.setDisplaySeriesShapes(true);
       
       // get a reference to the plot for further customisation...
       final XYPlot plot = chart.getXYPlot();
       plot.setBackgroundPaint(Color.lightGray);
   //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
       plot.setDomainGridlinePaint(Color.white);
       plot.setRangeGridlinePaint(Color.white);
       
       final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
       renderer.setSeriesLinesVisible(0, false);
       renderer.setSeriesShapesVisible(1, false);
       plot.setRenderer(renderer);

       // change the auto tick unit selection to integer units only...
       final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
       rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
       NumberAxis domain = (NumberAxis) plot.getDomainAxis();
       domain.setRange(1400000000, 1450000000);
       // OPTIONAL CUSTOMISATION COMPLETED.
               
       return chart;
       
   }
}
