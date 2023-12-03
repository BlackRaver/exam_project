import React from 'react';
import { RelictBase, TierInfo } from '../types';
import './DataTiles.css'
interface DataTilesProps {
  data: RelictBase;
}

const tierMap: { [key: number]: TierInfo } = {
  1: {tierLabel: 'LITH', imgPath: '/images/LithRelicIntact.png'},
  2: {tierLabel: 'MESO', imgPath: '/images/MesoRelicIntact.png'}, 
  3: {tierLabel: 'NEO', imgPath:  '/images/NeoRelicIntact.png'}, 
  4: { tierLabel: 'AXI', imgPath: '/images/AxiRelicIntact.png' },
};

function DataTiles({ data }: DataTilesProps): JSX.Element {
  const tierInfo:TierInfo  = tierMap[data.tier];

  if (!tierInfo) {
    // Handle cases where tier information is not available
    return <div className="data-tiles">Relict Information Not Found</div>;
  }

  const showRelictDetails = (id:string) => {
    console.log("Detle artefaktu o id:"+id)
  }


  return (
    <div className="data-tiles" onClick={() => showRelictDetails(data.name)}>
      {/* Render image if imgPath exists */}
      {tierInfo.imgPath && <img src={tierInfo.imgPath} alt={tierInfo.tierLabel} width="160" height="160" />} 
      <br/>
      <label>{tierInfo.tierLabel} {data.name} {data.relictID}</label>
    </div>
  );
}

export default DataTiles;
