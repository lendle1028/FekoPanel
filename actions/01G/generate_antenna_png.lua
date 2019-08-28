modelName = {}
modelName[1] = "Horn"
modelName[2] = "Patch"

app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--Horn.fek


    -- Create graphs 
    

    -- Create 3D Views
    view3D = app.Views[1]
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Top)  
    view3D.WindowTitle="Top"
    
    view3D = app.Views:Add(app.Models[1].Configurations[1])
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Bottom)  
    view3D.WindowTitle="Bottom"

    view3D = app.Views:Add(app.Models[1].Configurations[1])
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Left)
    view3D.WindowTitle="Left"

    view3D = app.Views:Add(app.Models[1].Configurations[1])
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Right)
    view3D.WindowTitle="Right"

    view3D = app.Views:Add(app.Models[1].Configurations[1])
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Front)
    view3D.WindowTitle="Front"

    view3D = app.Views:Add(app.Models[1].Configurations[1])
    view3D:SetViewDirection(pf.Enums.ViewDirectionEnum.Back)
    view3D.WindowTitle="Back"

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("載具模型-"..app.Views[index].WindowTitle, "png")
end

