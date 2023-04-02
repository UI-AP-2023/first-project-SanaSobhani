package controller;

import model.commodity.Commodity;
import model.commodity.CommodityScore;

public class CommodityController {
    public static int AverageCalculation(Commodity commodity){
        int sum =0, average;
        for(CommodityScore score : commodity.getCommodityScores())
            sum +=score.getPoint();
        average = sum/commodity.getCommodityScores().size();
        commodity.setAverageScore(average);
        return average;
    }
}
