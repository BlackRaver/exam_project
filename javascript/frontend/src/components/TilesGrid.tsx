import React from 'react';
import DataTiles from './DataTiles';

    const fetchData = async () => {
        try {
          const response = await fetch('http://localhost:8080/relict/all'); // Replace with your API endpoint
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
      
          const data = await response.json();
          return data;
        } catch (error) {
          console.error('Error fetching data:', error);
          // You can handle errors or return a default value here
          return null;
        }
      };
      
      // Usage of fetchData function
      const fetchAndUseData = async () => {
        try {
          const fetchedData = await fetchData();
          console.log('Fetched Data:', fetchedData);
            return fetchedData;
          // You can use the fetchedData here or pass it to other components/functions
        } catch (error) {
          console.error('Error:', error);
        }
      };





const TilesGrid = () => {
  // Example data, replace this with your actual data
  const data = fetchAndUseData();
  console.log("elo to jest test zmiennej",data)

  return (
    <div>
      <h2>Your Data Tiles</h2>
      <DataTiles data={data} />
    </div>
  );
};

export default TilesGrid;