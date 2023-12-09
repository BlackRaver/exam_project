import { RelictData } from "../types";
import "./RelictDetailsBox.css";

const RelictDetailsBox = ({children}) => {
const relictData:RelictData = children;

const valueMap: { [key: number]: string } = {
  1: 'Lith',
  2: 'Meso',
  3: 'Neo',
  4: 'Axi'
};

const tierName: string = valueMap[relictData.tier] || '';

    return (<>
    <div className="title">
        <h1>Sczegóły dotyczące reliktu</h1>
    </div>
    <div className="relicFrame">
         <div>
          <p>Name: {tierName} {relictData.name}</p>
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