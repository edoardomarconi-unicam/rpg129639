package players;

public class Parameters {
    /*all the parameters must be >= 0 e <=100*/

    private int health;
    private int education;
    private int fear;
    private int brotherhood;

    public Parameters() {
        this.health = 50;
        this.education = 50;
        this.fear = 50;
        this.brotherhood = 50;
    }

    public Parameters(int healt, int education, int fear, int brotherhood) {
        this.health = healt;
        this.education = education;
        this.fear = fear;
        this.brotherhood = brotherhood;
    }

    public int getHealth(){
        return this.health;
    }
    public int getEducation(){
        return this.education;
    }
    public int getFear(){
        return this.fear;
    }
    public int getBrotherhood(){
        return this.brotherhood;
    }

    public void changeAll(int changeHealt, int changeEducation, int changeFear, int changeBrotherhood) {
        this.health = changeHealt;
        this.education = changeEducation;
        this.fear = changeFear;
        this.brotherhood = changeBrotherhood;
    }

}
