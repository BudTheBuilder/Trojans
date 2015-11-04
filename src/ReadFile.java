import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class ReadFile {
	public static void main (String[] args) throws IOException {
		String s = readFile(args[0]);
		int numPoints = Integer.parseInt(args[1]);
		Pattern patt = Pattern.compile("((?:\\d+)\\.(?:\\d+)) (X|Y): \\((.+) --> (.+) \\((\\d+)\\)\\) (.+) \\((\\d+)\\)");
		Matcher match = patt.matcher(s);
		double xvals[] = new double[numPoints];
		int firstXvals[] = new int[numPoints];
		int secondXvals[] = new int[numPoints];
		int thirdXvals[] = new int[numPoints];
		int firstYvals[] = new int[numPoints];
		int secondYvals[] = new int[numPoints];
		int thirdYvals[] = new int[numPoints];
		int xInd = 0;
		int yInd = 0;
		while(match.find()){
			if(match.group(2).equals("X")) {
				xvals[xInd] = Double.parseDouble(match.group(1));
				firstXvals[xInd] = Integer.parseInt(match.group(3).substring(2, 5), 16);
				if(!(match.group(4).substring(2).length() > 5))
					secondXvals[xInd] = Integer.parseInt(match.group(4).substring(2), 16);
				thirdXvals[xInd] = Integer.parseInt(match.group(6).substring(2), 16);
				xInd++;
			}
			else if(match.group(2).equals("Y")) {
				xvals[yInd] = Double.parseDouble(match.group(1));
				firstYvals[yInd] = Integer.parseInt(match.group(3).substring(2), 16);
				secondYvals[yInd] = Integer.parseInt(match.group(4).substring(2), 16);
				thirdYvals[yInd] = Integer.parseInt(match.group(6).substring(2), 16);
				yInd++;
			}
		}
		
		
		
		LineChart_AWT chart = new LineChart_AWT(
			      "NoMovementPlot" ,
			      "NoMovment movement", xvals, firstXvals, secondXvals, thirdXvals, firstYvals, secondYvals, thirdYvals);

			      chart.pack( );
			      RefineryUtilities.centerFrameOnScreen( chart );
			      chart.setVisible( true );
		System.out.println("xInd: " + xInd + ", yInd: " + yInd);
		
	}
	public static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	public static long parseUnsignedHex(String text) {
        if (text.length() == 16) {
            return (parseUnsignedHex(text.substring(0, 1)) << 60)
                    | parseUnsignedHex(text.substring(1));
        }
        return Long.parseLong(text, 16);
    }
	
	
//	public XYSeries inputOutputGraph() {
//	    XYSeries graph = new XYSeries(new Integer());
//	    XYDataset xyDataset = new XYSeriesCollection(graph);
//	    graph.add(valuesToPlot.outputArray); //This line here is the issue
//	    JFreeChart chart = ChartFactory.createXYLineChart(
//	            " Array values", "Time", "values",
//	            xyDataset, PlotOrientation.VERTICAL, true, true, false);
//	    ChartFrame graphFrame = new ChartFrame("XYLine Chart", chart);
//	    graphFrame.setVisible(true);
//	    graphFrame.setSize(300, 300); 
//	    return graph;
//	} 
}
