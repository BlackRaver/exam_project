import React from "react";
import Navbar from "./Navbar";
import { useParams } from "react-router-dom";
import { useGetRelictByIdQuery } from "./api/apiRelict";
import { RelictData } from "../types";
import TilesFlexBox from "./TilesFlexBox";
import RelictDetailsBox from "./RelictDetailsBox";


const RelictDetailsPage = () =>{
    const param = useParams();
    const { data, isLoading, isError, error } = useGetRelictByIdQuery(param.id);

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (isError) {
        return <div>Error:</div>;
    }

    // Check if relict data exists before accessing its properties
    if (!data) {
        return <div>No data available for this relict.</div>;
    }

    const relict: RelictData = data;
   
    return (
        <div>
            <Navbar />
            <RelictDetailsBox>{relict}</RelictDetailsBox>
        </div>
    );
};

export default RelictDetailsPage;