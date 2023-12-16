import { RelictData } from "../types";
import "./RelictDetailsBox.css";

const RelictDetailsBox = ({children}) => {
const relictData:RelictData = children;

    return (<>
    <div className="title">
        <h1>Sczegóły dotyczące reliktu</h1>
    </div>
    <div className="relicFrame">
         <div>
          <p>{relictData.tier} {relictData.name}</p>
        </div>
        <div className="primeItemListBox">
       
          <h3>Możliwe nagrody:</h3>
          <ul className="primeItemList">
            {relictData.drop.map((dropItem, index) => (
              <li key={index} >
                <div className="itemRow">
                  <label className="primeItemListLabel label1">{dropItem.rarity}</label>
                  <label className="primeItemListLabel label2">Prime Item Name: {dropItem.primeItem.name}</label>
                  <label className="primeItemListLabel label3">Ducats: {dropItem.primeItem.ducats}</label>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>
      </>
        );
}

export default RelictDetailsBox;