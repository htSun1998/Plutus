export interface CategoryInfo {
    id: number,
    categoryName1: string,
    categoryName2: string,
    type: number,
    iconUrl: string,
    createUser: number,
    createTime: string,
    updateTime: string
}

interface TableData {
    id: number,
    name: string,
    type: number,
    iconUrl: string,
    createUser: number,
    createTime: string,
    updateTime: string,
    children: TableData[] | null
}

export function generateTableData(categoryList: any): TableData[] {
    const parents: CategoryInfo[] = []
    const children: CategoryInfo[] = []
    // 第一次遍历：找到父数据和子数据
    for (const category of categoryList) {
        if (category.categoryName1 && !category.categoryName2) {
            parents.push(category)
        } else if (category.categoryName1 && category.categoryName2) {
            children.push(category)
        }
    }
    // 第二次遍历：为每个父数据查找相应的子数据
    const reconstructedList: TableData[] = [];
    for (const parent of parents) {
        const parentData: TableData = {
            id: parent.id,
            name: parent.categoryName1,
            type: parent.type,
            iconUrl: parent.iconUrl,
            createUser: parent.createUser,
            createTime: parent.createTime,
            updateTime: parent.updateTime,
            children: []
        }
        for (const child of children) {
            if (child.categoryName1 === parent.categoryName1) {
                const childData: TableData = {
                    id: child.id,
                    name: child.categoryName2,
                    type: child.type,
                    iconUrl: child.iconUrl,
                    createUser: child.createUser,
                    createTime: child.createTime,
                    updateTime: child.updateTime,
                    children: null
                }
                parentData.children!.push(childData);
            }
        }
        reconstructedList.push(parentData);
    }
    return reconstructedList;
}