package com.example.demo;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.*;
import weka.core.converters.ConverterUtils;
import weka.filters.unsupervised.instance.imagefilter.ColorLayoutFilter;

import java.util.ArrayList;
import java.util.Arrays;

public class Classification {
    public static void main(String[] args) {
    }
    public void classify() throws Exception {
        Classifier classifier = (Classifier) SerializationHelper.read("C:\\Users\\damil\\Documents\\catModel.model");
        ArrayList<weka.core.Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("filename"));
        String string = "Abyssinian,AmericanBobtail,AmericanCurl,AmericanShorthair,AmericanWirehair,AppleheadSiamese,Balinese,Bengal,Birman,Bombay,BritishShorthair,Burmese,Burmilla,Calico,CanadianHairless,Chartreux,Chausie,Chinchilla,CornishRex,Cymric,DevonRex,DiluteCalico,DiluteTortoiseshell,DomesticLongHair,DomesticMediumHair,DomesticShortHair,EgyptianMau,ExoticShorthair,Extra-ToesCat-HemingwayPolydactyl,Havana,Himalayan,JapaneseBobtail,Javanese,Korat,LaPerm,MaineCoon,Manx,Munchkin,Nebelung,NorwegianForestCat,Ocicat,OrientalLongHair,OrientalShortHair,OrientalTabby,Persian,Pixiebob,Ragamuffin,Ragdoll,RussianBlue,ScottishFold,SelkirkRex,Siamese,Siberian,Silver,Singapura,Snowshoe,Somali,Sphynx-HairlessCat,Tabby,Tiger,Tonkinese,Torbie,Tortoiseshell,TurkishAngora,TurkishVan,Tuxedo,YorkChocolate";
        String[] strings = string.split(",");
        ArrayList<String> breeds = new ArrayList<>(Arrays.asList(strings));
        attributes.add(new Attribute("class",breeds));

        Instances instances = new Instances("myInstances",attributes,0);
        double[] instanceValue = new double[2];
        instanceValue[0] = instances.attribute(0).addStringValue("european-shorthair.jpg");
        instances.add(new DenseInstance(1.0,instanceValue));

        ColorLayoutFilter filter = new ColorLayoutFilter();
        filter.setImageDirectory("C:\\Users\\damil\\Downloads");
        String[] options = new String[3];
        options[0] = "false";
        options[1] = "false";
        options[2] = "C:\\\\Users\\\\damil\\\\Downloads\\\\european-shorthair.jpg";
        filter.run(instances,options);
        System.out.println(instances);
    }
}
