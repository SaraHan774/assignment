import java.util.ArrayList;
import java.util.Scanner;

public class SalesPeople{

    private ArrayList<Interaction> interactions = new ArrayList<>();

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public boolean addInteraction(Interaction interaction){
        return interactions.add(interaction);
    }

    public boolean deleteInteraction(String interactionId){
        for (int i = 0; i < interactions.size(); i++) {
            if(interactionId.equals(interactions.get(i).getId())){
                return interactions.remove(interactions.get(i));
            }
        }
        return false;
    }

    public boolean updateInteraction(String interactionId){

        printInteractionUpdateManual();

        Scanner s = new Scanner(System.in);
        String target = s.nextLine();
        String newInfo = "";
        boolean isDone = false;
        Interaction inter = null;
        for (int i = 0; i < interactions.size(); i++) {
            if(interactionId.equals(interactions.get(i).getId())){
                // 수정할 대상을 탐색해서 찾는다
                inter = interactions.get(i);
        }

        if(inter == null){
            return false;
        }

        while(!isDone) {
            switch (target) {
                case "date": {
                    newInfo = updateInfoPrompt(target);
                    inter.setDateOfInteraction(newInfo);
                    break;
                }
                case "method": {
                    newInfo = updateInfoPrompt(target);
                    inter.setInteractionMethod(newInfo);
                    break;
                }
                case "potential": {
                    newInfo = updateInfoPrompt(target);
                    inter.setPotential(newInfo);
                }
                case "0": {
                    isDone = true;
                }
                default: {
                    System.out.println("wrong input!");
                    break;
                    }
                }
            }
        }
        return true;
    }

    private void printInteractionUpdateManual(){
        System.out.println("Which information would you like to update?");
        System.out.println("OPTIONS : [date, method, potential]");
        System.out.println("Enter '0' when update is complete.");
    }

    private String updateInfoPrompt(String updateTarget){
        System.out.print("Type new " + updateTarget + " to update : ");
        return new Scanner(System.in).nextLine();
    }

    public void printAllInteractions(){
        for (int i = 0; i < interactions.size(); i++) {
            System.out.println("printing all interactions ... \n\n");
            System.out.println(interactions.get(i));
        }
    }
}
