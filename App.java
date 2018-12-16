package worksheet02.work;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(0);


        final java.util.List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("FrankSenatra1.txt");

        final Dimension dimension = new Dimension(920, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(0);
        wordCloud.setBackground(new PixelBoundryBackground("Circle2.png"));
        wordCloud.setBackgroundColor(new Color(0xFFFFFF));
        wordCloud.setFontScalar(new LinearFontScalar(20, 70));

        wordCloud.build(wordFrequencies);
    	wordCloud.writeToFile("gradient_redbluegreen.png");
    }
}