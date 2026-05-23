package Weekly_Contest_318;

import java.util.ArrayList;
import java.util.List;

public class Min_Total_Distance_Travelled {

	public static long recMinimumTotalDistance(List<Integer> robot, int[][] factory,int robotIndex,int factoryIndex) {
        
		if(robotIndex>= robot.size())
        	return 0l;
        
        if(factoryIndex>=factory.length||factory[factoryIndex][1]==0)
        	return Long.MAX_VALUE;
        
        int robotCoord=robot.get(robotIndex);
        int factoryCoord=factory[factoryIndex][0];
        int servicelableRobots=factory[factoryIndex][1];
        int newServiceableRobots=servicelableRobots-1;
        int dist=Math.abs(robotCoord-factoryCoord);
        factory[factoryIndex][1]=newServiceableRobots;
        long ans1=dist+ recMinimumTotalDistance(robot, factory, robotIndex+1, factoryIndex);
        factory[factoryIndex][1]=servicelableRobots;
        long ans2=recMinimumTotalDistance(robot, factory, robotIndex, factoryIndex+1);
        return Math.min(ans1,ans2);
        
    }
	
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        return recMinimumTotalDistance(robot, factory, 0, 0);
        
        
    }
	
	public static void main(String[] args) {
		List<Integer>robot= new ArrayList<>();
		robot.add(0);
		robot.add(4);
		robot.add(6);
		int factory[][]= {{2,2},{6,2}};
		System.out.println(minimumTotalDistance(robot, factory));

	}

}
