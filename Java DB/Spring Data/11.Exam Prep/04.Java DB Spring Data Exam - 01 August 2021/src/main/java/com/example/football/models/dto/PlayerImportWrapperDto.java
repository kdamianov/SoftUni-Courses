package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportWrapperDto {
    @XmlElement(name = "player")
    List<PLayerImportDto> players;

    public List<PLayerImportDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PLayerImportDto> players) {
        this.players = players;
    }
}
