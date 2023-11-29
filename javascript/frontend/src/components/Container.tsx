import React from 'react';
import { useGetRelictsQuery } from './api/apiRelict';
import { Relict } from '../types';

const Container = () => {
  const {
    data: relicts,
    isLoading,
    isSuccess,
    isError,
    error,
  } = useGetRelictsQuery({});

  let content: Relict[] = [];


  if (isLoading) {
    content.push({ id: 0,name: 'Loading...', tier: 0 }); // Placeholder data for loading state
  } else if (isSuccess) {
    // Assuming relicts is an array of objects with properties 'name' and 'tier'
    content = relicts; // Assuming relicts directly matches the Relict type
  } else if (isError) {
    // Error handling logic
    content.push({id:0, name: `Error: ${error}`, tier: 0 }); // Placeholder data for error state
  }

  return (
    <>
      <h2>Relicty</h2>
      {content.map((item)=> 
      <div>
        Id: {item.id}
        Name: {item.name}
        Tier: {item.tier}
      </div>
      )
      }
      </>
  );
};

export default Container;




      
