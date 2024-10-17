package com.example.demo;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.*;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Classification {
    private String mpeg7;
    private String arrfStart;

    Classification(String mpeg){
        mpeg7 = mpeg;
        arrfStart = "@relation 'cats-weka.filters.unsupervised.instance.imagefilter.EdgeHistogramFilter-DC:\\\\Users\\\\damil\\\\OneDrive - University of Birmingham\\\\Pictures\\\\wekatest-weka.filters.unsupervised.attribute.Remove-R1-weka.filters.unsupervised.attribute.Normalize-S1.0-T0.0-unset-class-temporarily'\n" +
                "\n" +
                "@attribute 'MPEG-7 Edge Histogram0' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram1' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram2' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram3' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram4' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram5' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram6' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram7' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram8' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram9' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram10' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram11' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram12' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram13' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram14' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram15' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram16' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram17' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram18' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram19' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram20' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram21' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram22' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram23' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram24' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram25' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram26' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram27' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram28' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram29' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram30' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram31' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram32' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram33' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram34' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram35' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram36' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram37' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram38' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram39' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram40' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram41' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram42' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram43' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram44' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram45' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram46' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram47' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram48' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram49' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram50' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram51' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram52' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram53' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram54' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram55' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram56' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram57' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram58' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram59' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram60' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram61' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram62' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram63' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram64' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram65' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram66' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram67' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram68' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram69' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram70' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram71' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram72' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram73' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram74' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram75' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram76' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram77' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram78' numeric\n" +
                "@attribute 'MPEG-7 Edge Histogram79' numeric\n" +
                "@attribute class {Abyssinian,AmericanBobtail,AmericanCurl,AmericanShorthair,AmericanWirehair,AppleheadSiamese,Balinese,Bengal,Birman,Bombay,BritishShorthair,Burmese,Burmilla,Calico,CanadianHairless,Chartreux,Chausie,Chinchilla,CornishRex,Cymric,DevonRex,DiluteCalico,DiluteTortoiseshell,DomesticLongHair,DomesticMediumHair,DomesticShortHair,EgyptianMau,ExoticShorthair,Extra-ToesCat-HemingwayPolydactyl,Havana,Himalayan,JapaneseBobtail,Javanese,Korat,LaPerm,MaineCoon,Manx,Munchkin,Nebelung,NorwegianForestCat,Ocicat,OrientalLongHair,OrientalShortHair,OrientalTabby,Persian,Pixiebob,Ragamuffin,Ragdoll,RussianBlue,ScottishFold,SelkirkRex,Siamese,Siberian,Silver,Singapura,Snowshoe,Somali,Sphynx-HairlessCat,Tabby,Tiger,Tonkinese,Torbie,Tortoiseshell,TurkishAngora,TurkishVan,Tuxedo,YorkChocolate}\n"
        +"@data\n";
    }
    public static void main(String[] args) {
    }
    public String classify() throws Exception {
        Classifier classifier = (Classifier) SerializationHelper.read("catModelEdge.model");
        File myArff = new File("cat.arff");
        FileWriter fileWriter = new FileWriter(myArff);
        fileWriter.write(arrfStart+mpeg7+"?");
        fileWriter.close();

        ConverterUtils.DataSource mySource = new ConverterUtils.DataSource("cat.arff");
        Instances myData = mySource.getDataSet();
        myData.setClassIndex(myData.numAttributes()-1);
        Instance newInstance = myData.instance(0);
        myArff.delete();
        return myData.classAttribute().value((int)classifier.classifyInstance(newInstance));


    }
}
