import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import models.Player;
import models.Round;
import models.Store;
import models.Timer;
import models.mules.EnergyMule;
import models.mules.FoodMule;
import models.mules.OreMule;


/**
 * Created by Charlie on 10/4/2015.
 */
public class StoreController {

    @FXML
    Button buyFoodMule;
    @FXML
    Button buyEnergyMule;
    @FXML
    Button buyOreMule;
    @FXML
    Button buyFood;
    @FXML
    Button buyEnergy;
    @FXML
    Button buyOre;
    @FXML
    Button sellFood;
    @FXML
    Button sellEnergy;
    @FXML
    Button sellOre;
    @FXML
    Button sellMule;

    private Player[] players;
    private Round round;
    private Timer timer;
    private Store store;



    public StoreController() {
        this.players = MuleUI.getInstance().getPlayerArray();
        this.round = new Round(MuleUI.getInstance().getPlayerArray());
        this.timer = new Timer();
        this.store = new Store(MuleUI.getInstance().getDifficulty());
    }

    @FXML
    public void handleTown() throws Exception {
        MuleUI.getInstance().loadTown();
    }

    @FXML
    public void handleBuyAction(ActionEvent event) throws Exception {
        Player p = MapScreenController.getInstance().getCurrentPlayer();
        Button clickedButton = (Button) event.getSource();
        String id = clickedButton.getId();
        System.out.print(id);
        switch(id) {
            case("buyFoodMule"):
                if (p.getMoney() >= 125 && p.getMule() == null) {
                    p.setMule(new FoodMule(p.getPlayerID(), null, p));
                    p.setMoney(p.getMoney() - 125);
                    System.out.println(p.getPlayerName() + " has a " + p.getMule().toString());
                    store.decrementMuleAmount();
                }
                break;
            case("buyEnergyMule"):
                if (p.getMoney() >= 150 && p.getMule() == null) {
                    p.setMule(new EnergyMule(p.getPlayerID(), null, p));
                    p.setMoney(p.getMoney() - 150);
                    store.decrementMuleAmount();
                }
                break;
            case("buyOreMule"):
                if (p.getMoney() >= 175 && p.getMule() == null) {
                    p.setMule(new OreMule(p.getPlayerID(), null, p));
                    p.setMoney(p.getMoney() - 175);
                    store.decrementMuleAmount();
                }
                break;
            case("buyFood"):
                if (p.getMoney() >= 30) {
                    p.setMoney(p.getMoney() - 30);
                    p.setFood(p.getFood() + 1);
                    store.decrementFoodAmount();
                }
                break;
            case("buyEnergy"):
                if (p.getMoney() >= 25) {
                    p.setMoney(p.getMoney() - 25);
                    p.setEnergy(p.getEnergy() + 1);
                    store.decrementEnergyAmount();
                }
            case("buyOre"):
                if (p.getMoney() >= 50) {
                    p.setMoney(p.getMoney() - 50);
                    p.setOre(p.getOre() + 1);
                    store.decrementOreAmount();
                }
                break;
            case("sellFood"):
                p.setMoney(p.getMoney() + 30);
                p.setFood(p.getFood() - 1);
                store.incrementFoodAmount();
                break;
            case("sellEnergy"):
                p.setMoney(p.getMoney() + 25);
                p.setEnergy(p.getEnergy() - 1);
                store.incrementEnergyAmount();
                break;
            case("sellOre"):
                p.setMoney(p.getMoney() + 50);
                p.setOre(p.getOre() - 1);
                store.incrementOreAmount();
                break;
            case("sellMule"):
                p.setMule(null);
                p.setMoney(p.getMoney() + 100);
                store.incrementMuleAmount();
                break;
        }
        p.updatePlayerScore();
    }
}
