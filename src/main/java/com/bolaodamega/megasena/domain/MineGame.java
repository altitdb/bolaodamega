package com.bolaodamega.megasena.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MineGame")
@TypeAlias("MineGame")
public class MineGame extends Game {

}
