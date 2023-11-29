import { createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'

export const apiRelict = createApi({
reducerPath: 'relicts',
baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080'}),
endpoints: (builder) => ({

    getRelicts: builder.query({
        query: () => '/relict/all'
    }),
}),

});

export const { useGetRelictsQuery } = apiRelict;