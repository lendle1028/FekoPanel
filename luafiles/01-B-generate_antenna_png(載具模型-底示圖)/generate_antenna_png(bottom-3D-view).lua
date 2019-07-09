modelName = {}
modelName[1] = "Horn"
modelName[2] = "Patch"

app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--Horn.fek


    -- Create graphs 
    

    -- Create 3D Views
    view3D = app.Views[1]
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Bottom)  
 
    -- Export all graphs in the 'CartesianGraphCollection'

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("載具模型-底示圖"..index, "png")
end
