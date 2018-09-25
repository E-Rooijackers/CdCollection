

class CdCollector
{
    public DataController dataController;
    public GraphicalUserInterface gui;
    
    public void main(String[] args)
    {
        this.dataController = new DataController();
        this.gui = new GraphicalUserInterface();
    }
}