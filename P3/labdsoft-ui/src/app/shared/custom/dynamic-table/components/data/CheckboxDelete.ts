import { SelectionModel } from '@angular/cdk/collections';
import { IPagedData } from './IPagedData';

export class CheckBoxDelete {
    selection = new SelectionModel<number>(true, []);
    listData!: IPagedData<any>;

    // caso o número de linhas selecionadas seja igual ao número total de linhas
    isAllSelected(){
        const numSelected = this.selection.selected.length;
        const numRows = this.listData.content.length;
        return numSelected === numRows;
    }

    //Seleciona todas as linhas se não estiverem todas selecionadas, senão limpa a seleção
    masterToggle(identifierProperty: string){
        if(this.isAllSelected()){
            this.selection.clear();
        } else{
            this.listData.content.forEach(row => this.selection.select(row[identifierProperty]));
        }
    }
}