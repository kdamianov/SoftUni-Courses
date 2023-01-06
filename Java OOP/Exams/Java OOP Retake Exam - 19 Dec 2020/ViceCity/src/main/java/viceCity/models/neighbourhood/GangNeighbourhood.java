package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;


public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();

        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());

        Player player = players.poll();
        Gun gun = guns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int bullets = gun.fire();
                player.takeLifePoints(bullets);
            }
            if (gun.canFire()) {
                player = players.poll();
            } else if (player.isAlive()) {
                gun = guns.poll();
            }

        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Deque<Gun> playerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun playerGun = playerGuns.poll();

                while (playerGun != null) {
                    while (playerGun.canFire() && mainPlayer.isAlive()) {
                        int bullets = playerGun.fire();
                        mainPlayer.takeLifePoints(bullets);
                    }
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                    playerGun = playerGuns.poll();

                }
            }
        }
    }
}
