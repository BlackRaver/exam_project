import { useGetRelictsQuery } from './api/apiRelict';

import DataTiles from './DataTiles';
import { RelictBase } from '../types';
import TilesFlexBox from './TilesFlexBox';


const Container = () => {
  const {
    data: relicts,
    isLoading,
    isSuccess,
    isError,
    error,
  } = useGetRelictsQuery({});

  let content: RelictBase[] = [];

  if (isLoading) {
    content.push({ relictID: 0,name: 'Loading...', tier: '0' }); // Displayed data for loading state
  } else if (isSuccess) {
    content = relicts; // Assuming relicts directly matches the Relict type
  } else if (isError) {
    // Error handling logic
    content.push({relictID:0, name: `Error: ${error}`, tier: '0' }); // Displayed comunicat for error state
  }

  return (
    <>
      <h2>Relikty</h2>
      <TilesFlexBox>
       {content.map((item) => (
        <div key={item.relictID}>
          <DataTiles data = {item} />
        </div>
      )) } 
      </TilesFlexBox>
      </>
  );
};

export default Container;




      
