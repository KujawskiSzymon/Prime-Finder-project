import java.util.Scanner;

public class PrimeThreads {
    public static void main(String[] args) {


        PrimeThreads pt = new PrimeThreads(args);

    }

    public PrimeThreads(String [] args) {
        PrimeFinder[] finder = new PrimeFinder[args.length];
        for(int i=0;i<args.length;i++){
            try{
                long count = Long.parseLong(args[i]);
                finder[i] = new PrimeFinder(count);
                System.out.println("Szukam liczby pierwszej" + count);

            }
            catch (NumberFormatException ex){
                System.out.println("Błąd "+ex.getMessage());
            }
        }
        boolean complete = false;
        while(!complete){
            complete=true;
            for(int j=0;j<finder.length;j++){
                if(finder[j]==null) continue;
                if(!finder[j].finished){
                    complete=false;
                }
                else {
                    displayResult(finder[j]);
                    finder[j]=null;
                }
            }
            try{
                Thread.sleep(1000);

            }catch (InterruptedException e){
                //nic
            }
        }
    }

    private void displayResult(PrimeFinder finder){
        System.out.println("Liczba pierwsza " + finder.target + " to " + finder.prime);
    }
}
