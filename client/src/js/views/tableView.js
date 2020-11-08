import { elements, compare } from '../views/base';

export const renderByDate = (data, sortReq) => {
    elements.dataTableBody.innerHTML = '';
    const { by, order } = sortReq;
    data.sort(compare(by, order));
    console.log(by, order);

    data.forEach(e => {
        let {
            vesselName,
            inVoyN,
            outVoyN,
            berthingTime,
            degreeOfChange,
            changeCount,
            departureTime,
            berthN,
            status,
            uniqueID,
        } = e;
        berthN = !berthN ? '-' : berthN;
        const markup = `
        <tr>
            <td>${vesselName}</td>
            <td>${inVoyN}</td>
            <td>${outVoyN}</td>
            <td class=${
                degreeOfChange == 0
                    ? ''
                    : degreeOfChange >= 1
                    ? 'big-change'
                    : 'small-change'
            }>${berthingTime}</td>
            <td>${changeCount}</td>
            <td>${departureTime}</td>
            <td>${berthN}</td>
            <td>${status}</td>
            <td>
                <div class="btn-favorite" uniqueID="${uniqueID}">Favorite</div>
            </td>
            <td>
                <div class="btn-subscribe" uniqueID="${uniqueID}">Subscribe</div>
            </td>
        </tr>
        `;
        elements.dataTableBody.insertAdjacentHTML('beforeend', markup);
    });
};
