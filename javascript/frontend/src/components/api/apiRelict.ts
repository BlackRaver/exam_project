import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const apiRelict = createApi({
  reducerPath: 'relicts',
  baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080' }),
  endpoints: (builder) => ({
    getRelicts: builder.query({
      query: () => '/relict/all',
    }),
    getRelictById: builder.query({
      query: (id) => `/relict/${id}`,
    }),
  }),
});

export const { useGetRelictsQuery, useGetRelictByIdQuery } = apiRelict;