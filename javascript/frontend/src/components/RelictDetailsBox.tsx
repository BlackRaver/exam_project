import { RelictData } from "../data/types";
import "./RelictDetailsBox.css";
import dropValue from "../data/relictDropChances.json";
import { useState } from "react";

const RelictDetailsBox = ({ children }) => {
  const relictData: RelictData = children;
  const [relictLevel, setRelictLevel] = useState(0);

  const getDropChanceValue = (rarity: string) => {
    if (dropValue[relictLevel]) {
      switch (rarity) {
        case "common":
          return dropValue[relictLevel].common || "N/A";
        case "uncommon":
          return dropValue[relictLevel].uncommon || "N/A";
        case "rare":
          return dropValue[relictLevel].rare || "N/A";
        default:
          return "N/A";
      }
    } else {
      return "N/A";
    }
  };

  return (
    <>
      <div className="title">
        <h1>Sczegóły dotyczące reliktu</h1>
      </div>
      <div className="relicFrame">
        <div>
          <p>
            {relictData.tier} {relictData.name}
          </p>
          {relictData.vaulted && (
            <p>
              Ten Relikt znajduje się obecnie w skarpcu Orokin, więc nie można
              go zdobyć
            </p>
          )}
          <h3>Możliwe nagrody:</h3>
        </div>

        <div className="primeItemTable">
          <table className="primeItemTable2">
            <thead>
              <tr>
                <th>Rzadkość:</th>
                <th>Nazwa przedmiotu:</th>
                <th>Dukaty:</th>
                <th>Szansa:</th>
              </tr>
            </thead>
            <tbody>
              {relictData.drop.map((dropItem, index) => (
                <tr key={index}>
                  <td>{dropItem.rarity}</td>
                  <td>{dropItem.primeItem.name}</td>
                  <td>{dropItem.primeItem.ducats}</td>
                  <td>{getDropChanceValue(dropItem.rarity)}%</td>
                </tr>
              ))}
            </tbody>
          </table>
          <button
            className={`relictLevelButton ${
              relictLevel == 0 ? "relictLevelButtonActive" : ""
            }`}
            onClick={() => setRelictLevel(0)}
          >
            Intact
          </button>
          <button
            className={`relictLevelButton ${
              relictLevel == 1 ? "relictLevelButtonActive" : ""
            }`}
            onClick={() => setRelictLevel(1)}
          >
            Exceptional
          </button>
          <button
            className={`relictLevelButton ${
              relictLevel == 2 ? "relictLevelButtonActive" : ""
            }`}
            onClick={() => setRelictLevel(2)}
          >
            Flawless
          </button>
          <button
            className={`relictLevelButton ${
              relictLevel == 3 ? "relictLevelButtonActive" : ""
            }`}
            onClick={() => setRelictLevel(3)}
          >
            Radiant
          </button>
        </div>
      </div>
    </>
  );
};

export default RelictDetailsBox;
