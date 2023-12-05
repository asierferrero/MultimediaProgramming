using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class behaviorScript : MonoBehaviour
{
    public Vector3 point1;
    public Vector3 point2;
    private Vector3 currentDirection;

    // Start is called before the first frame update
    void Start()
    {
        // Assign initial values to points and current direction
        point1 = new Vector3(5f, 0f, 10f);
        point2 = new Vector3(0f, 0f, 0f);
        currentDirection = Vector3.right; // Assuming the initial direction is to the right
        transform.position = Vector3.zero;//reset position to 0,0,0
    }

    // Update is called once per frame
    void Update()
    {
        // Check if the current position is to the left of x=10 and at z=0
        if (transform.position.x <= 10 && transform.position.z == 0)
        {
            // Set the direction to the right
            Vector3 direction = Vector3.right;

            // Move the object to the right
            transform.position += new Vector3(0.1f, 0, 0);

            // Change color when the direction changes
            if (direction != currentDirection)
            {
                currentDirection = direction;
                GetComponent<Renderer>().material.color = Random.ColorHSV();
            }
        }
        // Check if the current position is to the right of x=5 and below z=10
        else if (transform.position.x >= 5 && transform.position.z <= 10)
        {
            // Calculate the direction to point1 and normalize it
            Vector3 direction = (point1 - transform.position).normalized;

            // Move the object in the calculated direction
            transform.position += direction * 0.1f;

            // Change color when the direction changes
            if (direction != currentDirection)
            {
                currentDirection = direction;
                GetComponent<Renderer>().material.color = Random.ColorHSV();
            }
        }
        // If none of the above conditions are met
        else
        {
            // Calculate the direction to point2 and normalize it
            Vector3 direction = (point2 - transform.position).normalized;

            // Move the object in the calculated direction
            transform.position += direction * 0.1f;

            // Change color when the direction changes
            if (direction != currentDirection)
            {
                currentDirection = direction;
                GetComponent<Renderer>().material.color = Random.ColorHSV();
            }
        }

        // Reset the position to (0, 0, 0) if the x position is less than 0
        if (transform.position.x < 0)
        {
            transform.position = new Vector3(0, 0, 0);
        }
    }
}
